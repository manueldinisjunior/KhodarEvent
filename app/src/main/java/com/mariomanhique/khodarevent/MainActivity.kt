package com.mariomanhique.khodarevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mariomanhique.khodarevent.navigation.KhodarNavHost
import com.mariomanhique.khodarevent.ui.theme.KhodarEventTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KhodarEventTheme {
                // A surface container using the 'background' color from the theme
                KhodarApp(
                    windowSizeClass = calculateWindowSizeClass(activity = this),
                    accessToken = checkAccessToken(uiState = uiState)
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KhodarEventTheme {
        Greeting("Android")
    }
}