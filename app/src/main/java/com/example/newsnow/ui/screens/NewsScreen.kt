package com.example.newsnow.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsnow.ui.components.CategoryTabs
import com.example.newsnow.ui.components.NewsArticle
import com.example.newsnow.ui.components.SearchBar
import com.example.newsnow.ui.theme.NewsNowTheme
import com.example.newsnow.ui.theme.greySurface

val newsCategories = listOf(
    "Business",
    "Entertainment",
    "General",
    "Health",
    "Science",
    "Sports",
    "Technology",
    "BookMarks"
)

@Composable
@Preview
fun NewsScreen(
    navController: NavController = rememberNavController()
) {
    NewsNowTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 220.dp),
                color = greySurface,
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                shadowElevation = 8.dp
            ) {}

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchBar(
                        modifier = Modifier
                            .weight(6f)
                            .padding(start = 20.dp),
                        onQueryChange = {},
                        hint = "Search Latest News"
                    )

                    Icon(
                        modifier = Modifier
                            .weight(1f)
                            .width(32.dp)
                            .height(32.dp)
                            .clickable {

                            },
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        elevation = CardDefaults.cardElevation(16.dp),
                        colors = CardColors(
                            contentColor = Color.White,
                            containerColor = Color.White,
                            disabledContainerColor = Color.White,
                            disabledContentColor = Color.White
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(20.dp))
                    ) {}

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 40.dp, top = 40.dp),
                            text = "Breaking News",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        val newsItems = listOf("News 1", "News 2", "News 3", "News 4", "News 5")
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 15.dp),
                            contentPadding = PaddingValues(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(newsItems) {
                                NewsArticle(
                                    modifier = Modifier
                                        .width(300.dp)
                                )
                            }
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 40.dp, top = 40.dp),
                            text = "Categories",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        CategoryTabs(
                            modifier = Modifier
                                .padding(start = 20.dp, top = 10.dp, end = 20.dp),
                            categories = newsCategories,
                            onCategorySelected = {},
                            contentPadding = PaddingValues(horizontal = 20.dp)
                        )

                        LazyRow(
                            modifier = Modifier
                                .padding(top = 15.dp),
                            contentPadding = PaddingValues(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(newsItems) {
                                NewsArticle(
                                    modifier = Modifier
                                        .width(300.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}