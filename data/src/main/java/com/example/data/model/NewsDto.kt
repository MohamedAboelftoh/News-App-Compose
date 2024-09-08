package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.domain.model.News
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel

@Parcelize
@Entity(tableName = "NewsTable")
data class NewsDto(
    @PrimaryKey(autoGenerate = true)
    var id : Int ,
    @field:SerializedName("publishedAt")
    var publishedAt: String? = null,

    @field:SerializedName("author")
    var author: String? = null,

    @field:SerializedName("urlToImage")
    var urlToImage: String? = null,

    @field:SerializedName("description")
    var description: String? = null,


    @field:SerializedName("title")
    var title: String? = null,

    @field:SerializedName("url")
    var url: String? = null,

    @field:SerializedName("content")
    var content: String? = null
) : Parcelable{
    @IgnoredOnParcel
    @field:SerializedName("source")
    @Ignore
    var source: SourceDto?= null
    fun toNews():News{
        return News(
            publishedAt = publishedAt ,
            author = author ,
            urlToImage = urlToImage ,
            description = description ,
            title = title ,
            url = url ,
            content = content
        )
    }
}

