package com.example.beanquest.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.beanquest.Models.PopularDish

@Dao
interface DishDao {

    @Query("SELECT * FROM popular_dishes")
    fun getDishes(): List<PopularDish>

    @Insert
    fun addDish(dish: PopularDish)

    @Query("DELETE FROM popular_dishes WHERE foodName='something'")
    fun deleteDish()
}