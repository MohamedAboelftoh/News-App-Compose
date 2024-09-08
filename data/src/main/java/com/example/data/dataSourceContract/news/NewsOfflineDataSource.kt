package com.example.data.dataSourceContract.news

import com.example.data.model.NewsDto
import com.example.domain.model.News


interface NewsOfflineDataSource {
    suspend fun getNewsListFromDB(sourceId : String) : List<News>
    suspend fun saveNewsListToDB(newsList : List<NewsDto>)
}