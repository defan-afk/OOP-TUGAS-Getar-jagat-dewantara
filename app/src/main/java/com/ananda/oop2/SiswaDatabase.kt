package com.ananda.oop2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DataSiswa::class), version = 1)
abstract class SiswaDatabase : RoomDatabase() {
    abstract fun siswaDao(): SiswaDao
    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        SiswaDatabase::class.java, "database-name"
    ).build()
}