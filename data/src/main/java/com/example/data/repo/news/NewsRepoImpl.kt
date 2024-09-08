package com.example.data.repo.news

import com.example.data.common.NetWorkHandler
import com.example.data.dataSourceContract.news.NewsOfflineDataSource
import com.example.data.dataSourceContract.news.NewsOnlineDataSource
import com.example.data.model.NewsDto
import com.example.domain.model.News
import com.example.domain.repo.news.NewsRepo
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val newsOfflineDataSource: NewsOfflineDataSource ,
    private val newsOnlineDataSource: NewsOnlineDataSource ,
    private val netWorkHandler: NetWorkHandler
) : NewsRepo {
    override suspend fun getNewsList(sourceId: String): List<News> {
        return try {
            if(netWorkHandler.isOnline()){
                val news = newsOnlineDataSource.getNewsListFromAPI(sourceId)
                newsOfflineDataSource.saveNewsListToDB(news)
                news.map {
                    it.toNews()
                }
            }else{
                newsOfflineDataSource.getNewsListFromDB(sourceId)
            }
        }catch (ex : Exception){
            throw ex
        }
    }
}