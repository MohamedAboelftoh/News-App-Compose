package com.example.composenewsapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composenewsapp.R
import com.example.composenewsapp.ui.main.MainActivity
import com.example.composenewsapp.ui.theme.ComposeNewsAppTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNewsAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painterResource(id = R.drawable.background_screens),
                            contentScale = ContentScale.FillBounds
                        ),
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(.35f),
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription =null
                    )
                    Image(
                        modifier = Modifier.fillMaxSize(.35f),
                        painter = painterResource(id = R.drawable.route_signiture),
                        contentDescription =null )
                }
                Handler(mainLooper).postDelayed({
                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)
                },2000)
            }
        }
    }
}