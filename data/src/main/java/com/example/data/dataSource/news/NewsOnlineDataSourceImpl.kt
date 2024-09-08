package com.example.data.dataSource.news

import com.example.data.api.NewsServices
import com.example.domain.model.News
import com.example.data.dataSourceContract.news.NewsOnlineDataSource
import com.example.data.model.NewsDto
import javax.inject.Inject

class NewsOnlineDataSourceImpl @Inject constructor (
    private val newsServices: NewsServices
) : NewsOnlineDataSource {
    override suspend fun getNewsListFromAPI(sourceId: String): List<NewsDto> {
        try {
            return newsServices.getNews(sourceId = sourceId).articles!!
        }catch (ex : Exception){
            throw ex
        }
    }
}