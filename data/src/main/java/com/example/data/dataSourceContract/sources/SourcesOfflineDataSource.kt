package com.example.data.dataSourceContract.sources

import com.example.data.model.SourceDto
import com.example.domain.model.Source


interface SourcesOfflineDataSource {
    suspend fun getSourcesListFromDB(category : String) : List<Source>
    suspend fun saveSourcesListToDB(sourcesList : List<SourceDto>)
}