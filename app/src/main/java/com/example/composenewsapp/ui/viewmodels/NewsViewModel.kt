package com.example.composenewsapp.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.ui.api.ApiManager
import com.example.data.api.NewsServices
import com.example.data.model.SourceDto
import com.example.domain.model.News
import com.example.domain.model.Source
import com.example.domain.usecase.news.NewsUseCase
import com.example.domain.usecase.sources.SourcesUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NewsViewModel @Inject constructor (
    private val newsUseCase: NewsUseCase ,
    private val sourcesUseCase: SourcesUseCase
) : ViewModel() {
    var sourcesList = mutableStateOf<List<Source>>(listOf())
    var newsList = mutableStateOf<List<News>>(listOf())
    var selectedIndex = mutableIntStateOf(0)
    fun getNews(sourceId : String){
        viewModelScope.launch{
            try {
                newsList.value =  newsUseCase.getNews(sourceId)
            }catch (ex : Exception){
                Log.e("api" , "error exception ${ex.message}")
            }
        }
    }
    fun getSources(category : String){
         viewModelScope.launch {
             try {
                 sourcesList.value =  sourcesUseCase.getSources(category)
             }catch (ex : Exception){
                 Log.e("api" , "error exception ${ex.message}")
             }
        }
    }
}