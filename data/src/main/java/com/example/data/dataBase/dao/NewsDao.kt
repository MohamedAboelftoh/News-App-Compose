package com.example.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.NewsDto


@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewsListToDB(newsList : List<NewsDto>)
    @Query("SELECT * FROM newstable Where :sourceId ")
    suspend fun getNewsListFromDB(sourceId : String) : List<NewsDto>
}