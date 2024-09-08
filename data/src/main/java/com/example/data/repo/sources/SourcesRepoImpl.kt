package com.example.data.repo.sources

import com.example.data.api.NewsServices
import com.example.data.common.NetWorkHandler
import com.example.data.dataSourceContract.sources.SourcesOfflineDataSource
import com.example.data.dataSourceContract.sources.SourcesOnlineDataSource
import com.example.domain.model.Source
import com.example.domain.repo.sources.SourcesRepo
import javax.inject.Inject

class SourcesRepoImpl @Inject constructor (
    private val sourcesOfflineDataSource: SourcesOfflineDataSource ,
    private val sourcesOnlineDataSource: SourcesOnlineDataSource ,
    private val netWorkHandler: NetWorkHandler
) : SourcesRepo {
    override suspend fun getSourcesList(category: String): List<Source> {
        return try {
            if (netWorkHandler.isOnline()){
                val sources = sourcesOnlineDataSource.getSourcesListFromAPI(category)
                sourcesOfflineDataSource.saveSourcesListToDB(sources)
                sources.map {
                    it.toSource()
                }
            }else{
                sourcesOfflineDataSource.getSourcesListFromDB(category)
            }
        }catch (ex : Exception){
            throw ex
        }
    }
}