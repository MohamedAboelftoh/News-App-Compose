package com.example.domain.model


data class SearchResponse(

	val totalResults: Int? = null,

	val articles: List<News?>? = null,

	val status: String? = null
)