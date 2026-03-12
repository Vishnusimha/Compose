package com.vishnu.compose.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

private val showcaseCards = listOf("Analytics", "Campaign", "Retention", "Subscribers", "Revenue")

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun UnusedComponentsShowcaseScreen() {
    // SearchBar demo state.
    var query by remember { mutableStateOf("") }

    // PullToRefreshBox demo state.
    var refreshing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // Picker dialog toggles.
    var showDatePicker by remember { mutableStateOf(false) }
    var showDateRangePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    // Picker states used by DatePicker / DateRangePicker / TimePicker.
    val datePickerState = rememberDatePickerState()
    val dateRangeState = rememberDateRangePickerState()
    val timePickerState = rememberTimePickerState(is24Hour = false)

    // anchoredDraggable demo state (swipeable-like behavior).
    var dragTrackWidthPx by remember { mutableStateOf(0) }
    val density = LocalDensity.current
    val anchors = remember(dragTrackWidthPx, density) {
        val thumbAndPaddingPx = with(density) { (48.dp + 16.dp).toPx() }
        val endAnchor = (dragTrackWidthPx - thumbAndPaddingPx).coerceAtLeast(0f)
        DraggableAnchors {
            0 at 0f
            1 at endAnchor
        }
    }
    val anchoredState = remember(anchors) {
        AnchoredDraggableState(initialValue = 0, anchors = anchors)
    }

    PullToRefreshBox(
        isRefreshing = refreshing,
        onRefresh = {
            scope.launch {
                refreshing = true
                delay(900)
                refreshing = false
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(bottom = 20.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                // SearchBar: type text and press search to see result area update.
                // Keep SearchBar in collapsed mode inside LazyColumn.
                // Expanded SearchBar works best as a top-level overlay and can cause bad constraints here.
                Spacer(modifier = Modifier.height(42.dp))
                ShowcaseSectionHeader(
                    title = "SearchBar",
                    what = "Material search component for filtering/find flows.",
                    check = "Type text to test input behavior."
                )
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    inputField = {
                        SearchBarDefaults.InputField(
                            query = query,
                            onQueryChange = { query = it },
                            onSearch = { },
                            expanded = false,
                            onExpandedChange = { },
                            placeholder = { Text("Search campaigns") }
                        )
                    },
                    expanded = false,
                    onExpandedChange = { }
                ) {
                    // Intentionally empty for collapsed safe demo mode.
                }
                Spacer(modifier = Modifier.height(48.dp))
            }

            item { ShowcaseDivider() }

            item {
                // Buttons that open DatePicker / DateRangePicker / TimePicker dialogs.
                ShowcaseSectionHeader(
                    title = "Date / Time Pickers",
                    what = "Buttons that launch date, range, and time dialogs.",
                    check = "Tap each button and verify corresponding dialog opens."
                )
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(onClick = { showDatePicker = true }) {
                        Icon(Icons.Default.CalendarToday, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Date")
                    }
                    Button(onClick = { showDateRangePicker = true }) { Text("Date Range") }
                    Button(onClick = { showTimePicker = true }) { Text("Time") }
                }
            }

            item { ShowcaseDivider() }

            item {
                // TooltipBox: tap info icon to show tooltip bubble.
                ShowcaseSectionHeader(
                    title = "TooltipBox",
                    what = "Context help popup anchored to an element.",
                    check = "Tap info icon and verify tooltip text appears."
                )
                val tooltipState = rememberTooltipState()
                TooltipBox(
                    positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                    tooltip = { PlainTooltip { Text("TooltipBox demo TooltipBox demo") } },
                    state = tooltipState
                ) {
                    IconButton(onClick = { scope.launch { tooltipState.show() } }) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                    }
                }
            }

            item { ShowcaseDivider() }

            item {
                // Responsive container placeholder (acts as BoxWithConstraints learning slot).
                ShowcaseSectionHeader(
                    title = "Responsive Container",
                    what = "Placeholder section for responsive layout pattern demos.",
                    check = "Observe container styling and width behavior."
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(12.dp)
                ) {
                    Text("Responsive container demo")
                }
            }

            item { ShowcaseDivider() }

            item {
                // FlowColumn: children wrap into multiple columns automatically.
                ShowcaseSectionHeader(
                    title = "FlowColumn",
                    what = "Wrap layout that places children in multiple columns.",
                    check = "See chips continue into the next column after max items."
                )

                /*** FlowColumn is useful when items have dynamic size and need to wrap into the next column (top-to-bottom first, then left-to-right), rather than strict grid cells.
                Real-world usage ideas
                Filter chips in a narrow side panel where chip heights vary.
                “Quick actions” panel with mixed button sizes.
                Dynamic metadata blocks (tags, badges, pills) that don’t fit uniform grid rows.
                Compact dashboard widgets/cards where natural content height differs.
                 */
                FlowColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachColumn = 3
                ) {
                    listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta").forEach { tag ->
                        Surface(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                tag,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }

            item { ShowcaseDivider() }

            item {
                // Canvas: custom drawing (Olympic-style rings).
                ShowcaseSectionHeader(
                    title = "Canvas",
                    what = "Custom drawing API for graphics/charts.",
                    check = "Look for Olympic-style rings drawn directly on canvas."
                )
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFEEF4FF))
                ) {
                    val ringRadius = size.minDimension * 0.14f
                    val stroke = Stroke(width = ringRadius * 0.24f)
                    val startX = center.x - ringRadius * 2.2f
                    val topY = center.y - ringRadius * 0.55f
                    val bottomY = topY + ringRadius * 0.95f
                    val gap = ringRadius * 1.1f

                    val topRow = listOf(
                        Color(0xFF0085C7), // Olympic Blue
                        Color(0xFF000000), // Olympic Black
                        Color(0xFFDF0024) // Olympic Red
                    )
                    val bottomRow = listOf(
                        Color(0xFFF4C300), // Olympic Yellow
                        Color(0xFF009F3D) // Olympic Green
                    )

                    topRow.forEachIndexed { index, color ->
                        drawCircle(
                            color = color,
                            radius = ringRadius,
                            center = Offset(startX + (index * gap), topY),
                            style = stroke
                        )
                    }
                    bottomRow.forEachIndexed { index, color ->
                        drawCircle(
                            color = color,
                            radius = ringRadius,
                            center = Offset(startX + (gap * 0.55f) + (index * gap), bottomY),
                            style = stroke
                        )
                    }
                }
            }

            item { ShowcaseDivider() }

            item {
                // anchoredDraggable: drag the inner box horizontally between anchor points.
                ShowcaseSectionHeader(
                    title = "anchoredDraggable",
                    what = "Drag gesture API with anchor states.",
                    check = "Drag colored box left/right and feel anchor snapping."
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .onSizeChanged { dragTrackWidthPx = it.width }
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Box(
                        modifier = Modifier
                            .offset {
                                IntOffset(x = anchoredState.requireOffset().roundToInt(), y = 0)
                            }
                            .padding(8.dp)
                            .size(48.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .anchoredDraggable(anchoredState, Orientation.Horizontal),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            item { ShowcaseDivider() }

            item {
                // ListItem: Material list row with leading/trailing content.
                ShowcaseSectionHeader(
                    title = "ListItem",
                    what = "Prebuilt Material list row with slots.",
                    check = "Verify icon, headline, supporting text, and trailing label."
                )
                ListItem(
                    headlineContent = { Text("ListItem component") },
                    supportingContent = { Text("Material list row with headline and supporting text") },
                    leadingContent = { Icon(Icons.Default.Info, contentDescription = null) },
                    trailingContent = { Text("NEW") }
                )
            }

            item { ShowcaseDivider() }

            item {
                // HorizontalMultiBrowseCarousel: horizontally scroll cards.
                ShowcaseSectionHeader(
                    title = "HorizontalMultiBrowseCarousel",
                    what = "Material carousel for horizontal card browsing.",
                    check = "Swipe cards left/right."
                )

                val carouselState = rememberCarouselState { showcaseCards.size }

                HorizontalMultiBrowseCarousel(
                    state = carouselState,
                    preferredItemWidth = 170.dp,
                    itemSpacing = 10.dp,
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) { index ->

                    Card(modifier = Modifier.height(120.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.tertiaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(showcaseCards[index])
                        }
                    }

                }
            }

            item { ShowcaseDivider() }

            item {
                // Vertical carousel fallback: emulate carousel focus + peeking cards.
                ShowcaseSectionHeader(
                    title = "VerticalMultiBrowseCarousel (Fallback)",
                    what = "Vertical browse pattern fallback section.",
                    check = "Use Previous/Next and observe center focus with top/bottom peeks."
                )

                var verticalCarouselIndex by remember { mutableStateOf(0) }
                val previousIndex =
                    (verticalCarouselIndex - 1 + showcaseCards.size) % showcaseCards.size
                val nextIndex = (verticalCarouselIndex + 1) % showcaseCards.size

                Text(
                    "VerticalMultiBrowseCarousel (fallback demo)",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "${verticalCarouselIndex + 1} of ${showcaseCards.size}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    VerticalCarouselPeekCard(
                        label = showcaseCards[previousIndex],
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .fillMaxWidth()
                            .height(78.dp)
                            .graphicsLayer {
                                alpha = 0.45f
                                scaleX = 0.94f
                                scaleY = 0.94f
                            }
                    )

                    Card(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth()
                            .height(108.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.primaryContainer)
                                .padding(horizontal = 14.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = showcaseCards[verticalCarouselIndex],
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    VerticalCarouselPeekCard(
                        label = showcaseCards[nextIndex],
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(78.dp)
                            .graphicsLayer {
                                alpha = 0.45f
                                scaleX = 0.94f
                                scaleY = 0.94f
                            }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(
                        onClick = {
                            verticalCarouselIndex =
                                (verticalCarouselIndex - 1 + showcaseCards.size) % showcaseCards.size
                        }
                    ) {
                        Text("Previous")
                    }
                    Button(
                        onClick = {
                            verticalCarouselIndex =
                                (verticalCarouselIndex + 1) % showcaseCards.size
                        }
                    ) {
                        Text("Next")
                    }
                }
            }
        }
    }

    if (showDatePicker) {
        // DatePicker dialog: choose one date and close.
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = { Button(onClick = { showDatePicker = false }) { Text("OK") } },
            dismissButton = { Button(onClick = { showDatePicker = false }) { Text("Cancel") } }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    if (showDateRangePicker) {
        // DateRangePicker dialog: choose start/end dates and close.
        DatePickerDialog(
            onDismissRequest = { showDateRangePicker = false },
            confirmButton = { Button(onClick = { showDateRangePicker = false }) { Text("OK") } },
            dismissButton = { Button(onClick = { showDateRangePicker = false }) { Text("Cancel") } }
        ) {
            DateRangePicker(state = dateRangeState)
        }
    }

    if (showTimePicker) {
        // TimePicker dialog: choose time and close.
        AlertDialog(
            onDismissRequest = { showTimePicker = false },
            title = { Text("Select time") },
            text = { TimePicker(state = timePickerState) },
            confirmButton = { Button(onClick = { showTimePicker = false }) { Text("OK") } },
            dismissButton = { Button(onClick = { showTimePicker = false }) { Text("Cancel") } }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UnusedComponentsShowcaseScreenPreview() {
    UnusedComponentsShowcaseScreen()
}

@Composable
private fun ShowcaseDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(vertical = 2.dp),
        color = MaterialTheme.colorScheme.outlineVariant
    )
}

@Composable
private fun ShowcaseSectionHeader(
    title: String,
    what: String,
    check: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.SemiBold
    )
    Text(
        text = "What: $what",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Text(
        text = "Check: $check",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.primary
    )
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
private fun VerticalCarouselPeekCard(
    label: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

