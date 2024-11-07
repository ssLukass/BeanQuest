package com.example.beanquest.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_dishes")
data class PopularDish(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val foodName: String,
    val foodImage: String,
    val foodPrice: String
)