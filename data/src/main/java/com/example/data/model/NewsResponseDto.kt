package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class NewsResponseDto(

    @field:SerializedName("totalResults")
	val totalResults: Int? = null,

    @field:SerializedName("articles")
	val articles: List<NewsDto> ?= null,

    @field:SerializedName("status")
	val status: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("code")
    val code: String? = null
) : Parcelable