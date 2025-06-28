package com.example.ecohabits

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ecohabits.ui.theme.EcoHabitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoHabitsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   WebViewPage(modifier = Modifier.padding(innerPadding),"https://studio--ecohabits-io3bn.us-central1.hosted.app/")
                }
            }
        }
    }
}

@Composable
fun WebViewPage(modifier: Modifier = Modifier,url:String) {
    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(modifier = modifier,factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
        }
    }, update = {
        it.loadUrl(url)
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcoHabitsTheme {
        WebViewPage(modifier = Modifier,"https://studio--ecohabits-io3bn.us-central1.hosted.app/")
    }
}