package com.vishnu.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PracticeScreen() {
    // if we do like this all render on top of each other, to fix we must use column or ROW.
//    Spacer(modifier = Modifier.padding(8.dp))
//
//    Text(text = "profile Screen")
//    Spacer(modifier = Modifier.padding(32.dp))
//    Spacer(modifier = Modifier.padding(32.dp))
//    Text(text = "Hello Screen")
//
//    Spacer(modifier = Modifier.padding(32.dp))


    Column(
        modifier = Modifier.background(Color.LightGray),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {

        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = "Vishnu")

        Spacer(modifier = Modifier.padding(32.dp))
        Text(text = "Simha")
        Spacer(modifier = Modifier.padding(32.dp))
    }

    LazyColumn(modifier = Modifier) {
        item {

        }

        items(10) {

        }
    }

    val num = remember { mutableIntStateOf(0) }

    Button(modifier = Modifier.padding(16.dp), onClick = { num.intValue++ }) {
        Text("Click To increment")
    }

}

sealed class Screens(val route: String) {
    object Profile : Screens(route = "profile_screen")
    object Hello : Screens(route = "hello_screen")
}


@Preview(showBackground = true)
@Composable
fun Greeting() {

    Text(
        text = "Pichi Thai",
        color = Color.Cyan,
        fontSize = 28.sp,
        letterSpacing = 2.sp,
        lineHeight = 30.sp,
        maxLines = 2,
        minLines = 1,
        softWrap = true,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .background(Color(.2f, .2f, .3f, .3f))
            .padding(16.dp)
    )

//    Spacer(modifier = Modifier.height(8.dp))
//    Spacer(modifier = Modifier.height(8.dp))

//    Text(
//        text = "Pichi Thai",
//        color = Color.Cyan,
//        fontSize = 28.sp,
//        letterSpacing = 2.sp,
//        lineHeight = 30.sp,
//        modifier = Modifier.padding(23.dp),
//        maxLines = 2,
//        minLines = 1,
//        softWrap = true,
//        style = MaterialTheme.typography.bodyLarge
//    )

}
