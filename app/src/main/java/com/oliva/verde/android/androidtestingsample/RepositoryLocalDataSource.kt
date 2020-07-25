package com.oliva.verde.android.androidtestingsample

class RepositoryLocalDataSource(val db : AppDataBase) {
    fun insertAll(vararg  repositories : Repository) {
        db.repositoryDAO().insertAll(*repositories)
    }

    fun findByOwner(owner : String) : List<Repository> {
        return db.repositoryDAO().findByOwner(owner)
    }
}