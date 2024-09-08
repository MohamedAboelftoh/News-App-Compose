package com.example.data.dataSource.news

import com.example.domain.model.News
import com.example.data.dataBase.dao.NewsDao
import com.example.data.dataSourceContract.news.NewsOfflineDataSource
import com.example.data.model.NewsDto
import javax.inject.Inject

class NewsOfflineDataSourceImpl @Inject constructor (
    private val newsDao: NewsDao
) : NewsOfflineDataSource {
    override suspend fun getNewsListFromDB(sourceId: String): List<News> {
        try {
            return newsDao.getNewsListFromDB(sourceId).map {
                it.toNews()
            }
        }catch (ex : Exception){
            throw ex
        }
    }

    override suspend fun saveNewsListToDB(newsList: List<NewsDto>) {
        try {
            newsDao.insertNewsListToDB(newsList)
        }catch (ex : Exception){
            throw ex
        }
    }
}