package com.example.composenewsapp.ui.viewmodels


class NewsViewModelContract {

    interface ViewModel{
        fun invokeActions(action : Action)
    }
    sealed class Action{
        data class LoadNews(val sourceId: String) : Action()
        data class LoadSources(val category: String) : Action()
    }

}