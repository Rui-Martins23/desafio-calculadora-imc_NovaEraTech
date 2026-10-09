package com.example.imccomposedbroom.ui.navigation

import com.example.imccomposedbroom.domain.BmiCalculator

object ImcRoutes {
    const val SPLASH = "splash"
    const val INPUT = "input"
    const val HISTORY = "history"
    const val RESULT = "result?bmi={bmi}"
    const val BMI_ARG = "bmi"

    fun result(bmi: Double): String = "result?bmi=${BmiCalculator.format(bmi)}"
}

/*
enum class ImcRoutes {
    HISTORY,
    SPLASH,
    INPUT,
    RESULT
}*/
