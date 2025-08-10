package com.example.newsnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.newsnow.ui.screens.MyApp
import com.example.newsnow.ui.screens.SplashScreen
import com.example.newsnow.ui.theme.NewsNowTheme

class NewsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsNowTheme {
                MyApp()
            }
        }
    }
}