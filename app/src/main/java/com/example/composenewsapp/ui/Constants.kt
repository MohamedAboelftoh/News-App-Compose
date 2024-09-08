package com.example.composenewsapp.ui

import com.example.composenewsapp.R
import com.example.domain.model.Category

object Constants {
        val categories = listOf(
        Category("sports" , R.string.sports, R.drawable.ball , R.color.sports),
        Category("technology" , R.string.politic, R.drawable.politics , R.color.politic),
        Category("health" , R.string.health, R.drawable.health , R.color.health),
        Category("business" , R.string.business, R.drawable.business , R.color.business),
        Category("science" , R.string.science, R.drawable.science , R.color.science),
        Category("environment" , R.string.environment, R.drawable.environment , R.color.environment),
    )
}