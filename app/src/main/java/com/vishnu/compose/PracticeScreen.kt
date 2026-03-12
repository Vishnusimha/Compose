package com.vishnu.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

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


    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
//inside the  LazyColumn when using singe item we can do below way
            item {
                Text("1st part of screen")
                Text(
                    "Hello ",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Red
                )
            }

            item {
                Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
                    for (character in 'A'..'J') {
                        Text(
                            "$character",
                            modifier = Modifier.padding(4.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                            color = Color.Blue
                        )
                    }
                }
            }

            items(5) {
                Text(text = "Item $it", modifier = Modifier.padding(16.dp))
            }

        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 4.dp,
            color = Color(0xFFFF5722) // Deep Orange
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
            Text("2nd part of screen")
            Spacer(modifier = Modifier.padding(16.dp))
            Text("NEXT")

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                var nums = listOf(" I", " am", "learning", "jetpack")
                itemsIndexed(nums) { index, num ->
                    Text(
                        "@:$index is $num",
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Blue // Deep Orange
            )
//Images in a row


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .weight(1f)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    model = "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80",
                    contentDescription = "Sample Image",
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.padding(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.pin_dummy_photo),
                    contentDescription = "Sample Image",
                    modifier = Modifier.padding(16.dp)
                )

            }

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Blue // Deep Orange
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pin_dummy_photo),
                    contentDescription = "Sample Image",
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.padding(16.dp))

                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    model = "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80",
                    contentDescription = "Sample Image",
                    contentScale = ContentScale.Crop,
                )

            }

        }


    }


//    Column(
//        modifier = Modifier.background(Color.LightGray),
//        horizontalAlignment = Alignment.Start,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        Spacer(modifier = Modifier.padding(8.dp))
//
//        Text(text = "Vishnu")
//
//        Spacer(modifier = Modifier.padding(32.dp))
//        Text(text = "Simha")
//        Spacer(modifier = Modifier.padding(32.dp))
//    }


    val num = remember { mutableIntStateOf(0) }

//    Button(modifier = Modifier.padding(16.dp), onClick = { num.intValue++ }) {
//        Text("Click To increment")
//    }

}

@Preview(showBackground = true)
@Composable
fun BoxDesignPractice() {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.TopEnd)
        ) {
            Text(
                "Vishnu", modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("Vishnu")
                Spacer(modifier = Modifier.padding(8.dp))
                Text("Simha")
            }
        }

        Image(
            painter = painterResource(id = R.drawable.pin_dummy_photo),
            contentDescription = "Sample Image",
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Center)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingTextPraactice() {

    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "YOYO hello" +
                    " Testing...",
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

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "YOYOYO",
            color = Color.Cyan,
            fontSize = 28.sp,
            letterSpacing = 2.sp,
            lineHeight = 30.sp,
            modifier = Modifier.padding(23.dp),
            maxLines = 2,
            minLines = 1,
            softWrap = true,
            style = MaterialTheme.typography.bodyLarge
        )
    }


}


fun main() {
    for (i in 1..10) {
        println("Hello $i")
    }
}
