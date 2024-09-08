package com.example.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.dataBase.dao.NewsDao
import com.example.data.dataBase.dao.SourcesDao
import com.example.data.model.NewsDto
import com.example.data.model.SourceDto
import com.example.domain.model.News
import com.example.domain.model.Source

@Database(entities = [NewsDto::class , SourceDto::class] , version = 1 , exportSchema = false)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun sourcesDao() : SourcesDao
    abstract fun newsDao() : NewsDao

}