package com.example.domain.repo.news

import com.example.domain.model.News

interface NewsRepo {
    suspend fun getNewsList (sourceId : String) : List<News>
}