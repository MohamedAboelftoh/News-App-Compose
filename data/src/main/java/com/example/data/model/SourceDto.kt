package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Source
import com.google.gson.annotations.SerializedName

@Parcelize
@Entity(tableName = "SourcesTable")
data class SourceDto(
	@field:SerializedName("country")
	var country: String? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("description")
	var description: String? = null,

	@field:SerializedName("language")
	var language: String? = null,

	@field:SerializedName("id")
	@PrimaryKey(autoGenerate = false)
	var id: String ,

	@field:SerializedName("category")
	var category: String? = null,

	@field:SerializedName("url")
	var url: String? = null
) : Parcelable
{
	fun toSource():Source{
		return Source(
			country = country ,
			name = name ,
			description = description ,
			language =language ,
			id = id ,
			category = category ,
			url = url
		)
	}
}