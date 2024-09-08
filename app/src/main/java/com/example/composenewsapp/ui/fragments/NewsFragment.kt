package com.example.composenewsapp.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composenewsapp.R
import com.example.composenewsapp.ui.api.ApiManager
import com.example.composenewsapp.ui.theme.primaryColor
import com.example.composenewsapp.ui.viewmodels.NewsViewModel
import com.example.data.model.SourceDto
import com.example.data.model.SourcesResponseDto
import com.example.domain.model.Category
import com.example.domain.model.News
import com.example.domain.model.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun NewsFragment(
    category: String?,
    newsViewModel: NewsViewModel = hiltViewModel() ,
    navController: NavController
) {
    newsViewModel.getSources(category!!)
    Column(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        SourcesTaps(newsViewModel.sourcesList.value)
        NewsSources(
            listOf(
                News(
                    title = "jknvsi",
                    publishedAt = "ldf",
                    author = "kdfbmkd"
                ),
                News(
                    title = "jknvsi",
                    publishedAt = "ldf",
                    author = "kdfbmkd"
                ),
                News(
                    title = "jknvsi",
                    publishedAt = "ldf",
                    author = "kdfbmkd"
                ),
            ),//newsViewModel.newsList.value ,
            navController
        )
    }
}

@Composable
fun SourcesTaps(
    sourcesItemsList: List<Source>,
    newsViewModel: NewsViewModel = hiltViewModel(),
) {
    if (sourcesItemsList.isNotEmpty())
        ScrollableTabRow(
            selectedTabIndex = newsViewModel.selectedIndex.intValue,
            indicator = {},
            divider = {}
        ) {
            sourcesItemsList.forEachIndexed { index, source ->
                if (newsViewModel.selectedIndex.intValue == index) {
                    newsViewModel.getNews(source.id!!)
                }
                Tab(
                    text = { Text(text = source.name!!) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = primaryColor,
                    selected = newsViewModel.selectedIndex.intValue == index,
                    onClick = {
                        newsViewModel.selectedIndex.intValue = index
                    },
                    modifier = if (newsViewModel.selectedIndex.intValue == index)
                        Modifier
                            .padding(end = 5.dp)
                            .background(color = primaryColor, shape = RoundedCornerShape(50.dp))
                    else
                        Modifier
                            .padding(end = 5.dp)
                            .border(width = 2.dp, color = primaryColor, RoundedCornerShape(50.dp))
                )
            }
        }
}

@Composable
fun NewsSources(
    newsList: List<News> ,
    navController: NavController
) {
    LazyColumn() {
        items(count = newsList.size) {
            NewsCard(
                item = newsList[it] ,
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "news" ,
                        value = newsList[it]
                    )
                    navController.navigate(route = "details")
                }
                )
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NewsCard(item: News , onClick :()-> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp),
        onClick = {
            onClick()
        }
    ) {
        GlideImage(
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            model = item.urlToImage,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = item.author?:"",
            style = TextStyle(color = colorResource(id = R.color.gray2), fontSize = 15.sp)
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = item.title!!,
            style = TextStyle(color = Color.Black, fontSize = 19.sp)
        )
        Text(
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.End),
            text = item.publishedAt!!,
            style = TextStyle(color = colorResource(id = R.color.gray2), fontSize = 15.sp)
        )
    }
}
