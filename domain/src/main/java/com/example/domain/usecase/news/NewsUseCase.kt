package com.example.domain.usecase.news

import com.example.domain.model.News
import com.example.domain.repo.news.NewsRepo
import javax.inject.Inject

class NewsUseCase @Inject constructor (
    private val newsRepo: NewsRepo
)  {
    suspend fun getNews(sourceId : String):List<News>{
        return newsRepo.getNewsList(sourceId)
    }
}