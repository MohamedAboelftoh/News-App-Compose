package com.example.data.dataSourceContract.sources

import com.example.data.model.SourceDto
import com.example.domain.model.Source


interface SourcesOnlineDataSource {
    suspend fun getSourcesListFromAPI(category : String) : List<SourceDto>
}