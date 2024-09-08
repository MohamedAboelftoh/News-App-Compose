package com.example.data.api

import com.example.data.common.Constants
import com.example.data.model.NewsResponseDto
import com.example.data.model.SearchResponseDto
import com.example.data.model.SourcesResponseDto
import com.example.domain.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {
    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") apiKey: String? = Constants.ApI_KEY,
        @Query("category") category: String
    ): SourcesResponseDto

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String? = Constants.ApI_KEY,
        @Query("sources") sourceId: String
    ): NewsResponseDto

    @GET("v2/everything")
    suspend fun search(
        @Query("apiKey") apiKey: String? = Constants.ApI_KEY,
        @Query("q") q: String
    ): SearchResponseDto
}