package com.vishnu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vishnu.compose.presentation.BestPracticeScreen
import com.vishnu.compose.presentation.NetflixInspiredScreen
import com.vishnu.compose.presentation.PinterestInspiredScreen
import com.vishnu.compose.presentation.SpotifyInspiredScreen
import com.vishnu.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {
//                BestPracticeScreen()
//                NetflixInspiredScreen()
                SpotifyInspiredScreen()
//                PinterestInspiredScreen()
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
    ComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun greeting(string: String){

}