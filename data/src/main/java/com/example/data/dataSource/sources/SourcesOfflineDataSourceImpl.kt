package com.example.data.dataSource.sources

import com.example.domain.model.Source
import com.example.data.dataBase.dao.SourcesDao
import com.example.data.dataSourceContract.sources.SourcesOfflineDataSource
import com.example.data.model.SourceDto
import javax.inject.Inject

class SourcesOfflineDataSourceImpl @Inject constructor (
    private val sourcesDao: SourcesDao
) : SourcesOfflineDataSource {
    override suspend fun getSourcesListFromDB(category: String): List<Source> {
        try {
            return sourcesDao.getSourcesListFromDB(category).map {
                it.toSource()
            }
        }catch (ex : Exception){
            throw ex
        }
    }

    override suspend fun saveSourcesListToDB(sourcesList: List<SourceDto>) {
        try {
            sourcesDao.insertSourcesToDB(sourcesList)
        }catch (ex : Exception){
            throw ex
        }
    }
}