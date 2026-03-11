package com.vishnu.compose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishnu.compose.R

private data class PinItem(
    val id: Int,
    val title: String,
    val author: String,
    val imageHeight: Int,
    val colors: List<Color>,
    val imageRes: Int?,
    val assetType: String?
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinterestInspiredScreen() {
    val categories = remember {
        listOf("For You", "Decor", "Fitness", "Fashion", "Travel", "Recipes", "Design")
    }
    val pins = remember {
        listOf(
            PinItem(
                1,
                "Cozy living room ideas",
                "by Studio Loft",
                220,
                listOf(
                    Color(0xFFE3F2FD), // Light Blue 50
                    Color(0xFF90CAF9) // Light Blue 200
                ),
                null, null
            ),
            PinItem(
                2,
                "Minimal desk setup",
                "by Workmode",
                160,
                listOf(
                    Color(0xFFE8F5E9), // Green 50
                    Color(0xFFA5D6A7) // Green 200
                ),
                R.drawable.pin_dummy_photo,
                "XML Vector"
            ),
            PinItem(
                3,
                "Warm lighting moodboard",
                "by Home Glow",
                260,
                listOf(
                    Color(0xFFFFF3E0), // Orange 50
                    Color(0xFFFFCC80) // Orange 200
                ),
                R.drawable.mind_map2,
                "PNG"
            ),
            PinItem(
                4,
                "Capsule wardrobe picks",
                "by Daily Style",
                190,
                listOf(
                    Color(0xFFF3E5F5), // Purple 50
                    Color(0xFFCE93D8) // Purple 200
                ),
                null, null
            ),
            PinItem(
                5,
                "Healthy meal prep",
                "by Fit Kitchen",
                230,
                listOf(
                    Color(0xFFE0F7FA), // Cyan 50
                    Color(0xFF80DEEA) // Cyan 200
                ),
                null, null
            ),
            PinItem(
                6,
                "Sunday brunch table",
                "by Food Stories",
                170,
                listOf(
                    Color(0xFFFFEBEE), // Red 50
                    Color(0xFFEF9A9A) // Red 200
                ),
                R.drawable.pin_dummy_pic,
                "XML Vector"
            ),
            PinItem(
                7,
                "Nature travel spots",
                "by Explore Now",
                210,
                listOf(
                    Color(0xFFE8EAF6), // Indigo 50
                    Color(0xFF9FA8DA) // Indigo 200
                ),
                R.drawable.pin_dummy_photo,
                "XML Vector"
            ),
            PinItem(
                8,
                "Plant shelf inspiration",
                "by Green Corner",
                250,
                listOf(
                    Color(0xFFF1F8E9), // Light Green 50
                    Color(0xFFC5E1A5) // Light Green 200
                ),
                R.drawable.mind_map2,
                "PNG"
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Discover",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Create pin")
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.size) { index ->
                    AssistChip(
                        onClick = { },
                        label = { Text(categories[index]) }
                    )
                }
            }
// For large card Views
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 88.dp,
                    top = 4.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(pins) { pin ->
                    PinCard(pin = pin)
                }
            }

//            LazyHorizontalGrid(
//                rows = GridCells.Fixed(2),
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(
//                    start = 12.dp,
//                    end = 12.dp,
//                    bottom = 88.dp,
//                    top = 4.dp
//                ),
//                horizontalArrangement = Arrangement.spacedBy(10.dp),
//                verticalArrangement = Arrangement.spacedBy(10.dp)
//            ) {
//                items(pins) { pin ->
//                    PinCard(pin = pin)
//                }
//            }
        }
    }
}

@Composable
private fun PinCard(pin: PinItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(pin.imageHeight.dp)
                    .background(brush = Brush.verticalGradient(pin.colors)) // Gradient tint behind dummy image.
            ) {
                if (pin.imageRes != null) {
                    Image(
                        painter = painterResource(id = pin.imageRes),
                        contentDescription = "Pin preview image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = pin.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = pin.author,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (pin.assetType != null) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Asset: ${pin.assetType}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PinterestInspiredScreenPreview() {
    PinterestInspiredScreen()
}
