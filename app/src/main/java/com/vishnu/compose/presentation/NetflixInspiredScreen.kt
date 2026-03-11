package com.vishnu.compose.presentation

/*
 UI Hierarchy (Top -> Bottom)

 Surface (screen background)
   -> Scaffold (screen structure)
      -> TopAppBar
         -> Text("StreamX")
         -> IconButton
            -> Icon(Notifications)
      -> LazyColumn (scrollable content)
         -> item: HeroBanner
            -> Box
               -> Column
                  -> Text("The Silent Case")
                  -> Text("Crime • Thriller • 2h 08m")
                  -> Row
                     -> Button(Play)
                        -> Icon(PlayArrow)
                        -> Spacer
                        -> Text("Play")
                     -> Button(My List)
                        -> Text("My List")
         -> items: CategoryRow [repeated]
            -> Column
               -> Text(row.title)
               -> LazyRow
                  -> PosterCard [repeated]
                     -> Card
                        -> Box
                           -> Text(title)
*/

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishnu.compose.ui.theme.ComposeTheme

private data class ContentRow(
    val title: String,
    val posters: List<String>
)

private data class NetflixPalette(
    val screenBackground: Color,
    val topBarContainer: Color,
    val topBarContent: Color,
    val heroStart: Color,
    val heroEnd: Color,
    val heroTitle: Color,
    val heroMeta: Color,
    val primaryButtonContainer: Color,
    val primaryButtonContent: Color,
    val secondaryButtonContainer: Color,
    val secondaryButtonContent: Color,
    val categoryTitle: Color,
    val cardContainer: Color,
    val cardGradientStart: Color,
    val cardGradientEnd: Color,
    val cardTitle: Color
)

@Composable
private fun rememberNetflixPalette(isDarkTheme: Boolean): NetflixPalette {
    return remember(isDarkTheme) {
        NetflixPalette(
            screenBackground = if (isDarkTheme) Color(0xFF0B0B0B) else Color(0xFFFFFFFF), // Rich Black / White
            topBarContainer = if (isDarkTheme) Color(0xFF0B0B0B) else Color(0xFFFFFFFF), // Rich Black / White
            topBarContent = if (isDarkTheme) Color(0xFFFFFFFF) else Color(0xFF111111), // White / Near Black
            heroStart = Color(0xFFB20710), // Netflix Red
            heroEnd = Color(0xFF111111), // Near Black
            heroTitle = Color(0xFFFFFFFF), // White
            heroMeta = Color(0xFFE0E0E0), // Gray 300
            primaryButtonContainer = Color(0xFFFFFFFF), // White
            primaryButtonContent = Color(0xFF000000), // Black
            secondaryButtonContainer = Color(0xFF2A2A2A), // Charcoal
            secondaryButtonContent = Color(0xFFFFFFFF), // White
            categoryTitle = if (isDarkTheme) Color(0xFFFFFFFF) else Color(0xFF111111), // White / Near Black
            cardContainer = Color(0xFF161616), // Graphite Black
            cardGradientStart = Color(0xFFB20710), // Netflix Red
            cardGradientEnd = Color(0xFF1A1A1A), // Dark Gray
            cardTitle = Color(0xFFFFFFFF) // White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetflixInspiredScreen() {
    val isDarkTheme = isSystemInDarkTheme()
    val palette = rememberNetflixPalette(isDarkTheme = isDarkTheme)
    val rows = remember {
        listOf(
            ContentRow(
                "Continue Watching",
                listOf("North Light", "8th Floor", "The Last Port", "Unknown Call")
            ),
            ContentRow(
                "Trending Now",
                listOf("Reckoning", "Skyline", "Parallel", "The Loop", "Dark River")
            ),
            ContentRow(
                "Only on StreamX",
                listOf("Pulse", "Afterglow", "Untold", "Mirage", "Redline")
            ),
            ContentRow(
                "Sci-Fi Picks",
                listOf("Orbit", "Neon City", "Beyond", "Zero Day", "Stellar")
            )
        )
    }

    // Screen hierarchy root:
    // Surface -> Scaffold -> TopAppBar + LazyColumn content
    Surface(color = palette.screenBackground) {
        Scaffold(
            containerColor = palette.screenBackground,
            topBar = {
                // Top bar hierarchy: TopAppBar -> Text("StreamX") + IconButton(Notifications)
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = palette.topBarContainer,
                        titleContentColor = palette.topBarContent,
                        actionIconContentColor = palette.topBarContent
                    ),
                    title = {
                        Text(
                            text = "StreamX",
                            color = palette.topBarContent,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notifications",
                                tint = palette.topBarContent
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                item {
                    // Content section 1: featured hero banner
                    HeroBanner(palette = palette)
                }
                items(rows) { row ->
                    // Content section 2: repeated content category rows
                    CategoryRow(row = row, palette = palette)
                }
            }
        }
    }
}

/*
 HeroBanner hierarchy:
 Box
   -> Column
      -> Text("The Silent Case")
      -> Text("Crime • Thriller • 2h 08m")
      -> Row
         -> Button(Play)
            -> Icon(PlayArrow)
            -> Spacer
            -> Text("Play")
         -> Button(My List)
            -> Text("My List")
*/
@Composable
private fun HeroBanner(palette: NetflixPalette) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.verticalGradient(
                    listOf(palette.heroStart, palette.heroEnd)
                )
            )
            .padding(20.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "The Silent Case",
                color = palette.heroTitle,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Crime • Thriller • 2h 08m",
                color = palette.heroMeta,
                style = MaterialTheme.typography.bodyMedium
            )
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = palette.primaryButtonContainer,
                        contentColor = palette.primaryButtonContent
                    )
                ) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Play")
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = palette.secondaryButtonContainer,
                        contentColor = palette.secondaryButtonContent
                    )
                ) {
                    Text("My List")
                }
            }
        }
    }
}

/*
 CategoryRow hierarchy:
 Column
   -> Text(row.title)
   -> LazyRow
      -> PosterCard [repeated]
         -> Card
            -> Box
               -> Text(title)
*/
@Composable
private fun CategoryRow(row: ContentRow, palette: NetflixPalette) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            text = row.title,
            color = palette.categoryTitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(row.posters) { title ->
                PosterCard(title = title, palette = palette)
            }
        }
    }
}

/*
 PosterCard hierarchy:
 Card
   -> Box
      -> Text(title)
*/
@Composable
private fun PosterCard(title: String, palette: NetflixPalette) {
    Card(
        modifier = Modifier.size(width = 120.dp, height = 176.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = palette.cardContainer)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(palette.cardGradientStart, palette.cardGradientEnd)
                    )
                )
                .padding(10.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = title,
                color = palette.cardTitle,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(name = "Netflix Dark", showBackground = true, backgroundColor = 0xFF121212)
@Composable
private fun NetflixInspiredScreenDarkPreview() {
    ComposeTheme(darkTheme = true, dynamicColor = false) {
        NetflixInspiredScreen()
    }
}

@Preview(name = "Netflix Light", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun NetflixInspiredScreenLightPreview() {
    ComposeTheme(darkTheme = false, dynamicColor = false) {
        NetflixInspiredScreen()
    }
}

