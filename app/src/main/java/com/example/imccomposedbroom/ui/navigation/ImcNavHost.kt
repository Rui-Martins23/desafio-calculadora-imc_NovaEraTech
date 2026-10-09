package com.example.imccomposedbroom.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.imccomposedbroom.data.local.BmiRecord
import com.example.imccomposedbroom.data.local.ImcDatabase
import com.example.imccomposedbroom.domain.BmiCalculator
import com.example.imccomposedbroom.ui.history.HistoryScreen
import com.example.imccomposedbroom.ui.input.InputScreen
import com.example.imccomposedbroom.ui.result.ResultScreen
import com.example.imccomposedbroom.ui.splash.SplashScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ImcNavHost() {
    val context = LocalContext.current
    val dao = remember { ImcDatabase.getInstance(context).bmiDao() }
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ImcRoutes.SPLASH,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(ImcRoutes.SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(ImcRoutes.INPUT) {
            InputScreen(
                onCalculated = { result ->
                    scope.launch(Dispatchers.IO) {
                        dao.insert(
                            BmiRecord(
                                weightKg = result.weightKg,
                                heightMeters = result.heightMeters,
                                bmi = result.bmi,
                                classification = BmiCalculator.classify(result.bmi),
                                calculatedAt = System.currentTimeMillis()
                            )
                        )
                    }
                    navController.navigate(ImcRoutes.result(result.bmi))
                },
                onHistoryClick = {
                    navController.navigate(ImcRoutes.HISTORY)
                }
            )
        }
        composable(ImcRoutes.HISTORY) {
            var items by remember { mutableStateOf(emptyList<BmiRecord>()) }

            LaunchedEffect(Unit) {
                items = dao.getAll()
            }

            HistoryScreen(
                records = items
            ){ itemId ->
                scope.launch(Dispatchers.IO) {
                    dao.deleteById(itemId)
                    items = dao.getAll()
                }
            }
        }
        composable(
            route = ImcRoutes.RESULT,
            arguments = listOf(
                navArgument(ImcRoutes.BMI_ARG){ type = NavType.StringType }
            )
        ) {entry ->
            val bmi = entry.arguments?.getString(ImcRoutes.BMI_ARG)?.toDoubleOrNull() ?: 0.0

            ResultScreen(
                bmi = bmi
            )
        }
    }
}