package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class SearchResponseDto(

    @field:SerializedName("totalResults")
	val totalResults: Int? = null,

    @field:SerializedName("articles")
	val articles: List<NewsDto?>? = null,

    @field:SerializedName("status")
	val status: String? = null
) : Parcelable