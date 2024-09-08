package com.example.data.dataSource.sources

import com.example.data.api.NewsServices
import com.example.domain.model.Source
import com.example.data.dataSourceContract.sources.SourcesOnlineDataSource
import com.example.data.model.SourceDto
import javax.inject.Inject

class SourcesOnlineDataSourceImpl @Inject constructor (
    private val newsServices: NewsServices
) : SourcesOnlineDataSource {
    override suspend fun getSourcesListFromAPI(category: String): List<SourceDto> {
        try {
            return newsServices.getSources(category = category).sources!!
        }catch (ex : Exception){
            throw ex
        }
    }
}