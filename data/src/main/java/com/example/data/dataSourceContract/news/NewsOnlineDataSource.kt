package com.example.data.dataSourceContract.news

import com.example.data.model.NewsDto
import com.example.domain.model.News


interface NewsOnlineDataSource {
    suspend fun getNewsListFromAPI(sourceId : String) : List<NewsDto>
}