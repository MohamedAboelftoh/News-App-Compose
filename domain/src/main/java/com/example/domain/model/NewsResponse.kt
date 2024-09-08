package com.example.domain.model

data class NewsResponse(

	val totalResults: Int? = null,

	val articles: List<News?>? = null,

	val status: String? = null,

    val message: String? = null,

    val code: String? = null
)