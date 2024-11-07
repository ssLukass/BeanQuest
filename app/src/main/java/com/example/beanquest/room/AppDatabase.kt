package com.example.beanquest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.beanquest.Models.PopularDish

@Database(entities = [PopularDish::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dishDao(): DishDao

    companion object {
        private const val DATABASE_NAME = "my.db"
        private var DATABASE: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            DATABASE?.let { return it }

            synchronized(LOCK) {
                DATABASE?.let { return it }

                val db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).createFromAsset("my.db").allowMainThreadQueries().build()

                DATABASE = db
                return db
            }
        }
    }
}