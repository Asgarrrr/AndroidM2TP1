package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.myapplication.ui.navigation.HomeNavHost
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                HomeNavHost()
            }
        }
    }
}


//package com.example.myapplication
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.compose.rememberNavController
//import coil.compose.rememberAsyncImagePainter
//import coil.request.ImageRequest
//import com.example.myapplication.ui.navigation.HomeNavHost
//import com.example.myapplication.ui.theme.MyApplicationTheme
//
//@Composable
//private fun MyScreen() {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background,
//    ) {
//
//        Column (
//            modifier = Modifier
//                .fillMaxSize(),
//        ) {
//            val painter = rememberAsyncImagePainter(
//                ImageRequest
//                    .Builder(LocalContext.current)
//                    .data(data = "https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExamhvZDUxYzFrZXJ6bnJqdDU0amVzbzZoZjMwMXh3ZTVuazB2Z2YzZCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/MaCAVIpjoelYQ/giphy.gif")
//                    .build()
//            )
//            Image(
//                modifier = Modifier.size(128.dp),
//                painter = painter,
//                contentDescription = null,
//            )
//        }
//
//    }
//}
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val navController = rememberNavController()
//            MyApplicationTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                ) {
//
//                    HomeNavHost(
//                        navController = navController
//                    ) // Will be red for the beginning
//                }
//            }
//        }
//
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        MyScreen()
//    }
//}