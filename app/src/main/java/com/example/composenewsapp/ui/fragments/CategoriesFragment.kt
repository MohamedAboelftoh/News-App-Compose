package com.example.composenewsapp.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composenewsapp.R
import com.example.composenewsapp.ui.Constants
import com.example.domain.model.Category

@Composable
fun CategoriesFragment(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background_screens),
                contentScale = ContentScale.FillHeight
            ),
    ){
        Text(
            modifier = Modifier.padding(vertical = 20.dp , horizontal = 15.dp),
            text = stringResource(id = R.string.pick_your_category_n_of_interest),
            style = TextStyle(
                fontSize = 18.sp ,
                color = Color.Black
            )
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2) ){
            items(count = 6){
                val item = Constants.categories[it]
                CategoryCard(item = item, position = it, onClick = {
                    navController.navigate(route = "news/${item.apiId}")
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(item : Category , position: Int , onClick :()-> Unit) {
    Card(
        onClick = {
                  onClick()
        },
        modifier = Modifier.padding(horizontal = 8.dp , vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = item.color)),
        shape = if(position%2==0)
                 RoundedCornerShape(
                    topStart = 10.dp ,
                    topEnd = 10.dp ,
                    bottomStart = 10.dp,
                    bottomEnd = 0.dp
            ) else
                RoundedCornerShape(
                        topStart = 10.dp ,
                        topEnd = 10.dp ,
                        bottomStart = 0.dp,
                        bottomEnd = 10.dp
                    )
    ) {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally).height(100.dp),
            painter = painterResource(id = item.image),
            contentDescription =null ,
            contentScale = ContentScale.FillHeight
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 10.dp),
            text = stringResource(id = item.name),
            style = TextStyle(
                fontSize = 18.sp ,
                color = Color.White
            )
        )
    }
}