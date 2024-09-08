package com.example.composenewsapp.ui.fragments

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composenewsapp.R
import com.example.domain.model.News

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsNewsItemFragment(newsTitle : News) {
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 10.dp, horizontal = 20.dp)
) {
    val context = LocalContext.current
    GlideImage(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        model = newsTitle.urlToImage ?: "",
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
    Text(
        modifier = Modifier.padding(top = 10.dp),
        text = newsTitle.author ?: "",
        style = TextStyle(color = colorResource(id = R.color.gray1), fontSize = 15.sp)
    )
    Text(
        modifier = Modifier.padding(top = 10.dp),
        text = newsTitle.title ?: "",
        style = TextStyle(color = colorResource(id = R.color.gray2), fontSize = 19.sp)
    )
    Text(
        modifier = Modifier
            .padding(top = 10.dp)
            .align(Alignment.End),
        text = newsTitle.publishedAt ?: "",
        style = TextStyle(color = colorResource(id = R.color.gray1), fontSize = 15.sp)
    )
    Text(
        modifier = Modifier.padding(top = 10.dp),
        text = newsTitle.content ?: "",
        style = TextStyle(color = colorResource(id = R.color.gray1), fontSize = 15.sp)
    )
    Row(
        modifier = Modifier.align(Alignment.End).clickable {
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse(newsTitle.url))
            context.startActivity(intent)
        } ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "View Full Article" ,
            style = TextStyle(
                color = colorResource(id = R.color.gray1),
                fontSize = 15.sp
            )
        )
        Icon(
            modifier =  Modifier,
            painter = painterResource(id = R.drawable.ic_view),
            contentDescription = null
        )
    }
}
}