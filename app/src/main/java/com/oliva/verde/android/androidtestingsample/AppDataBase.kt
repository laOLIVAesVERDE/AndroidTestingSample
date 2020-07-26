package com.oliva.verde.android.androidtestingsample

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Repository::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun repositoryDAO() : RepositoryDao
}