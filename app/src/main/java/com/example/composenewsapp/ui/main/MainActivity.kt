package com.example.composenewsapp.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composenewsapp.R
import com.example.composenewsapp.ui.fragments.CategoriesFragment
import com.example.composenewsapp.ui.fragments.DetailsNewsItemFragment
import com.example.composenewsapp.ui.fragments.NewsFragment
import com.example.composenewsapp.ui.fragments.SettingsFragment
import com.example.composenewsapp.ui.theme.ComposeNewsAppTheme
import com.example.composenewsapp.ui.theme.primaryColor
import com.example.domain.model.News
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNewsAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val navController = rememberNavController()
                var title by remember {
                    mutableStateOf("")
                }
                ModalNavigationDrawer(
                    drawerContent = {
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            DrawerHeader()
                            DrawerBody(navController = navController, drawerState = drawerState)
                        }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = { NewsTopBar(drawerState , title) },
                    ) {
                        NavHost(
                            modifier = Modifier
                                .padding(it),
                            navController = navController,
                            startDestination = "categories"
                        ) {
                            composable(route = "categories") {
                                CategoriesFragment(navController)
                                title  = stringResource(id = R.string.news_app)
                            }
                            composable(route = "settings") {
                                SettingsFragment()
                                title  = stringResource(id = R.string.setting)
                            }
                            composable(
                                route = "news/{category}",
                                arguments = listOf(navArgument(name = "category") {
                                    type = NavType.StringType
                                }
                                )
                            ) {
                                val argument = it.arguments?.getString("category")
                                NewsFragment(argument , navController = navController)
                                title  = argument ?: ""
                            }
                            composable(
                                route = "details"
                                ) {
                                val result = navController.previousBackStackEntry?.savedStateHandle?.get<News>("news")
                                DetailsNewsItemFragment(result ?: News())
                                title  = stringResource(id = R.string.news_title)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopBar(drawerState: DrawerState , title: String) {
    val coroutineScope = rememberCoroutineScope()
    CenterAlignedTopAppBar(
        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
        title = {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                )
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = primaryColor,
        ),
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                },
                imageVector = Icons.Default.List,
                contentDescription = null, tint = Color.White,
            )
        }
    )
}

@Composable
fun DrawerHeader() {
    Text(
        text = stringResource(id = R.string.news_app),
        modifier = Modifier
            .fillMaxWidth(.5f)
            .background(primaryColor)
            .padding(vertical = 20.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = Color.White,
            fontSize = 20.sp
        )
    )
}

@Composable
fun DrawerBody(navController: NavController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth(.5f)
            .fillMaxHeight()
            .background(Color.White)
            .padding(top = 10.dp)
    ) {
        DrawerItem(
            icon = R.drawable.categories_ic,
            title = R.string.categories,
            onClick = {
                navController.navigate(route = "categories")
                coroutineScope.launch {
                    drawerState.close()
                }
            })
        Spacer(modifier = Modifier.padding(5.dp))
        DrawerItem(
            icon = R.drawable.settings_ic,
            title = R.string.setting,
            onClick = {
                navController.navigate(route = "settings")
                coroutineScope.launch {
                    drawerState.close()
                }
            })
    }
}

@Composable
fun DrawerItem(icon: Int, title: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = stringResource(id = title))
    }
}
