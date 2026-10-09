package com.example.imccomposedbroom.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BmiDao {

    @Query("SELECT * FROM bmi_calculations ORDER BY calculatedAt DESC")
    suspend fun getAll(): List<BmiRecord>

    @Insert
    fun insert(record: BmiRecord)

    @Query("DELETE FROM bmi_calculations WHERE id = :id")
    fun deleteById(id: Long)

    // @Delete
    // fun deleteById(record: BmiRecord)
}