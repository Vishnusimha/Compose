package com.vishnu.compose.presentation

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PauseCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class CinemaAlbum(val title: String, val subtitle: String)

@Composable
fun SpotifyRealisticScreen() {
    val quickPicks = remember {
        listOf(
            CinemaAlbum("Lo-Fi Focus", "Made for coding"),
            CinemaAlbum("Deep Work", "Instrumental"),
            CinemaAlbum("Evening Drive", "Mood mix"),
            CinemaAlbum("Top Hits", "Global chart")
        )
    }
    val playlists = remember {
        listOf(
            CinemaAlbum("Daily Mix 1", "Pop + Indie"),
            CinemaAlbum("Discover Weekly", "Fresh recommendations"),
            CinemaAlbum("Release Radar", "New drops for you"),
            CinemaAlbum("Chill Tracks", "Ambient and mellow"),
            CinemaAlbum("Liked Songs", "248 tracks")
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0F0F0F)
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = { MiniPlayerBar() }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item {
                    HeaderSection()
                }
                item {
                    QuickPickRow(quickPicks)
                }
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Your playlists",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(playlists) { album ->
                    PlaylistListItem(album = album)
                }
            }
        }
    }
}

@Composable
private fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFF1DB954), Color(0xFF0F0F0F))
                )
            )
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // Greeting with current time
        Text(
            text = "Good evening",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Decorative subtitle
        Text(
            text = "Enjoy your music experience",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB3B3B3),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Top action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Quick action buttons
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                color = Color(0xFF282828)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Updates",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = 1
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                color = Color(0xFF282828)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Settings",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickPickRow(items: List<CinemaAlbum>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = "Quick picks for you",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { item ->
                // Album card with better proportions
                Surface(
                    modifier = Modifier
                        .size(width = 180.dp, height = 100.dp)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(Color(0xFF1DB954), Color(0xFF1aa34a))
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF1F1F1F),
                    shadowElevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Album thumbnail
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    brush = Brush.linearGradient(
                                        listOf(Color(0xFF1DB954), Color(0xFF1aa34a))
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )

                        // Title and subtitle
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.title,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = item.subtitle,
                                color = Color(0xFFE0E0E0),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PlaylistListItem(album: CinemaAlbum) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF282828),
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Album thumbnail with gradient
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color(0xFF1DB954), Color(0xFF1aa34a))
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
            )

            // Title and subtitle
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = album.title,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = album.subtitle,
                    color = Color(0xFFB3B3B3),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Like button with icon
            IconButton(
                onClick = { },
                modifier = Modifier.size(44.dp)
            ) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Like",
                    tint = Color(0xFF1DB954),
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
private fun MiniPlayerBar() {
    // Track progress state (0.0 to 1.0)
    val isPlaying = remember { androidx.compose.runtime.mutableStateOf(true) }
    val isFavorite = remember { androidx.compose.runtime.mutableStateOf(false) }
    val currentProgress = 0.45f // 45% through the song (e.g., 2:15 out of 5:00)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF121212))
    ) {
        // Progress bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(Color(0xFF404040))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(currentProgress)
                    .height(3.dp)
                    .background(Color(0xFF1DB954))
            )
        }

        // Player bar content
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF282828)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) {
                // Song info with album art
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Album thumbnail
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(Color(0xFF1DB954), Color(0xFF1aa34a))
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    // Title and artist
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Night Changes",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "One Direction",
                            color = Color(0xFFB3B3B3),
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    // Like button
                    IconButton(
                        onClick = { isFavorite.value = !isFavorite.value },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            if (isFavorite.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Like",
                            tint = if (isFavorite.value) Color(0xFF1DB954) else Color(0xFFB3B3B3),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Playback controls
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Shuffle button
                    IconButton(
                        onClick = { },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.Shuffle,
                            contentDescription = "Shuffle",
                            tint = Color(0xFFB3B3B3),
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Previous button
                    IconButton(
                        onClick = { },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.SkipPrevious,
                            contentDescription = "Previous",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    // Play/Pause button (center, larger)
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFF1DB954),
                        modifier = Modifier.size(52.dp)
                    ) {
                        IconButton(
                            onClick = { isPlaying.value = !isPlaying.value },
                            modifier = Modifier.size(52.dp)
                        ) {
                            Icon(
                                if (isPlaying.value) Icons.Default.PauseCircle else Icons.Default.PlayArrow,
                                contentDescription = if (isPlaying.value) "Pause" else "Play",
                                tint = Color.Black,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    // Next button
                    IconButton(
                        onClick = { },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.SkipNext,
                            contentDescription = "Next",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Repeat button
                    IconButton(
                        onClick = { },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.Repeat,
                            contentDescription = "Repeat",
                            tint = Color(0xFFB3B3B3),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F0F0F)
@Composable
private fun SpotifyInspiredScreenPreview() {
    SpotifyRealisticScreen()
}

