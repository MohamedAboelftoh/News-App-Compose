package com.example.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.SourceDto

@Dao
interface SourcesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSourcesToDB(sourcesList : List<SourceDto>)
    @Query("SELECT * FROM sourcestable WHERE category = :category")
    suspend fun getSourcesListFromDB(category : String) :  List<SourceDto>
}