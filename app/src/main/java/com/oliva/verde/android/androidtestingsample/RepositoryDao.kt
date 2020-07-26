package com.oliva.verde.android.androidtestingsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepositoryDao {
    @Insert
    fun insertAll(vararg  repositories : Repository)

    @Query("SELECT * FROM repository WHERE owner = :owner")
    fun findByOwner(owner : String) : List<Repository>
}