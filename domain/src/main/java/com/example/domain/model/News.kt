package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    var publishedAt: String? = null,

    var author: String? = null,

    var urlToImage: String? = null,

    var description: String? = null,

    var title: String? = null,

    var url: String? = null,

    var content: String? = null
):Parcelable

