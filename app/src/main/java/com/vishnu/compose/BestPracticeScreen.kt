package com.vishnu.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

/**
 * BEST PRACTICE SCREEN
 *
 * This screen demonstrates:
 * 1. Proper Compose architecture (Scaffold → Layout → Sections → Components)
 * 2. All major UI components with extensive parameter usage
 * 3. All layout types (Column, Row, Box, LazyColumn, LazyRow)
 * 4. Modifier chains with multiple properties
 * 5. State management
 * 6. Navigation Drawer integration
 * 7. Material3 components
 * 8. Best practices for scalable Compose UI
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BestPracticeScreen() {

    // State management
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedTab by remember { mutableIntStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }

    // Layer 1: Navigation Drawer (Side Drawer)
    ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(
                    onCloseDrawer = {
                        scope.launch { drawerState.close() }
                    }
                )
            }
        ) {
            // Layer 2: Scaffold (Screen Structure)
            Scaffold(

                topBar = {
                    TopBarSection(
                        onMenuClick = {
                            scope.launch { drawerState.open() }
                        }
                    )
                },

                bottomBar = {
                    BottomNavigationSection()
                },

                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { showDialog = true },
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        shape = CircleShape,
                        modifier = Modifier
                            .size(56.dp)
                            .shadow(
                                elevation = 6.dp,
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add new item"
                        )
                    }
                }

            ) { paddingValues ->

                // Layer 3: Main Content Container
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues) // passing paddingValues from Scaffold
                        .background(MaterialTheme.colorScheme.background),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    // Section 1: Text Components Showcase
                    item {
                        TextComponentsSection()
                    }

                    // Section 2: Button Components Showcase
                    item {
                        ButtonComponentsSection()
                    }

                    // Section 3: Card Components Showcase
                    item {
                        CardComponentsSection()
                    }

                    // Section 4: Input Components Showcase
                    item {
                        InputComponentsSection()
                    }

                    // Section 5: Selection Components Showcase
                    item {
                        SelectionComponentsSection()
                    }

                    // Section 6: Progress Indicators Showcase
                    item {
                        ProgressIndicatorsSection()
                    }

                    // Section 7: Horizontal Scrolling (LazyRow)
                    item {
                        HorizontalScrollSection()
                    }

                    // Section 8: Box Layout with Overlays
                    item {
                        BoxLayoutSection()
                    }

                    // Section 9: Complex Row Layouts
                    item {
                        ComplexRowLayoutSection()
                    }

                    // Section 10: Tab Layout
                    item {
                        TabLayoutSection(
                            selectedTab = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    }

                    // Section 11: List Items
                    item {
                        ListItemsSection()
                    }

                    // Section 12: Badge Components
                    item {
                        BadgeComponentsSection()
                    }

                    // Section 13: Dividers
                    item {
                        DividersSection()
                    }
                }

                // Dialog overlay
                if (showDialog) {
                    DialogSection(onDismiss = { showDialog = false })
                }
            }
        }
}

// ============================================
// SECTION 1: TEXT COMPONENTS
// ============================================
@Composable
fun TextComponentsSection() {
    SectionContainer(title = "Text Components") {

        // Basic Text
        Text(text = "Basic Text")

        Spacer(modifier = Modifier.height(8.dp))

        // Text with ALL possible parameters and modifiers
        Text(
            text = "Complete Text Example",
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE3F2FD), //
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF1976D2),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { /* Handle click */ }
                .alpha(1f)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            color = Color(0xFF0D47A1),
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            letterSpacing = 0.5.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp,
            overflow = TextOverflow.Ellipsis,
            softWrap = true,
            maxLines = 2,
            minLines = 1,
            style = TextStyle(
                background = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Styled text with SpanStyle
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                    append("Red Bold ")
                }
                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 20.sp)) {
                    append("Blue Large ")
                }
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("Strikethrough")
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Material Typography
        Text(
            text = "Display Large",
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = "Headline Medium",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Body Medium",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Label Small",
            style = MaterialTheme.typography.labelSmall
        )
    }
}

// ============================================
// SECTION 2: BUTTON COMPONENTS
// ============================================
@Composable
fun ButtonComponentsSection() {
    SectionContainer(title = "Button Components") {

        // Filled Button with all parameters
        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(12.dp)),
            enabled = true,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp
            ),
            border = BorderStroke(2.dp, Color(0xFF3700B3)),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Filled Button",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Outlined Button
        OutlinedButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Outlined Button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Elevated Button
        ElevatedButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Elevated Button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Text Button
        TextButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Text Button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Filled Tonal Button
        FilledTonalButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Filled Tonal Button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Icon Button
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
            IconButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Default.Share, contentDescription = "Share")
            }
            IconButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}

// ============================================
// SECTION 3: CARD COMPONENTS
// ============================================
@Composable
fun CardComponentsSection() {
    SectionContainer(title = "Card Components") {

        // Basic Card with all parameters
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF3E0),
                contentColor = Color(0xFF5D4037),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp,
                pressedElevation = 12.dp,
                focusedElevation = 8.dp,
                hoveredElevation = 10.dp,
                draggedElevation = 12.dp,
                disabledElevation = 0.dp
            ),
            border = BorderStroke(2.dp, Color(0xFFFF6F00)),
            onClick = { /* Handle click */ }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Card Title",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "This is a card with all possible parameters demonstrated.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Elevated Card
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Elevated Card", fontWeight = FontWeight.Bold)
                Text("Has higher elevation than basic card")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Outlined Card
        OutlinedCard(
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Outlined Card", fontWeight = FontWeight.Bold)
                Text("Has a border instead of elevation")
            }
        }
    }
}

// ============================================
// SECTION 4: INPUT COMPONENTS
// ============================================
@Composable
fun InputComponentsSection() {
    SectionContainer(title = "Input Components") {

        var textFieldValue by remember { mutableStateOf("") }
        var outlinedTextFieldValue by remember { mutableStateOf("") }

        // TextField with all parameters
        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            enabled = true,
            readOnly = false,
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            label = { Text("Label") },
            placeholder = { Text("Enter text here") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = { textFieldValue = "" }) {
                    Icon(Icons.Default.Delete, contentDescription = "Clear")
                }
            },
            prefix = { Text("Prefix: ") },
            suffix = { Text(" suffix") },
            supportingText = { Text("Supporting text goes here") },
            isError = false,
            singleLine = true,
            maxLines = 1,
            minLines = 1,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE8F5E9),
                unfocusedContainerColor = Color(0xFFF1F8E9),
                focusedIndicatorColor = Color(0xFF4CAF50),
                unfocusedIndicatorColor = Color(0xFF8BC34A)
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Outlined TextField
        OutlinedTextField(
            value = outlinedTextFieldValue,
            onValueChange = { outlinedTextFieldValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Outlined TextField") },
            placeholder = { Text("Type something") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            singleLine = true
        )
    }
}

// ============================================
// SECTION 5: SELECTION COMPONENTS
// ============================================
@Composable
fun SelectionComponentsSection() {
    SectionContainer(title = "Selection Components") {

        var checkedState by remember { mutableStateOf(true) }
        var switchState by remember { mutableStateOf(true) }
        var selectedOption by remember { mutableStateOf("Option 1") }
        var sliderValue by remember { mutableFloatStateOf(0.5f) }

        // Checkbox with all parameters
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it },
                modifier = Modifier.size(32.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF6200EE),
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White,
                    disabledCheckedColor = Color.LightGray,
                    disabledUncheckedColor = Color.LightGray,
                    disabledIndeterminateColor = Color.LightGray
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Checkbox with full configuration",
                modifier = Modifier.clickable { checkedState = !checkedState }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Switch with all parameters
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Switch: ")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = switchState,
                onCheckedChange = { switchState = it },
                modifier = Modifier.scale(1.2f),
                enabled = true,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF4CAF50),
                    checkedTrackColor = Color(0xFFC8E6C9),
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.LightGray,
                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent,
                    disabledCheckedThumbColor = Color.LightGray,
                    disabledCheckedTrackColor = Color.LightGray,
                    disabledUncheckedThumbColor = Color.LightGray,
                    disabledUncheckedTrackColor = Color.LightGray,
                    disabledCheckedBorderColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent
                ),
                thumbContent = {
                    Icon(
                        imageVector = if (switchState) Icons.Default.Favorite else Icons.Outlined.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Radio Buttons
        Column {
            Text("Radio Buttons:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            listOf("Option 1", "Option 2", "Option 3").forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedOption = option }
                        .padding(vertical = 4.dp)
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option },
                        enabled = true,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFFFF6F00),
                            unselectedColor = Color.Gray,
                            disabledSelectedColor = Color.LightGray,
                            disabledUnselectedColor = Color.LightGray
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = option)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Slider with all parameters
        Column {
            Text(
                text = "Slider: ${String.format("%.2f", sliderValue)}",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                modifier = Modifier.fillMaxWidth(),
                enabled = true,
                valueRange = 0f..1f,
                steps = 10,
                onValueChangeFinished = { /* Called when user stops dragging */ },
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFE91E63),
                    activeTrackColor = Color(0xFFE91E63),
                    activeTickColor = Color(0xFFAD1457),
                    inactiveTrackColor = Color(0xFFF8BBD0),
                    inactiveTickColor = Color(0xFFE91E63),
                    disabledThumbColor = Color.LightGray,
                    disabledActiveTrackColor = Color.LightGray,
                    disabledActiveTickColor = Color.LightGray,
                    disabledInactiveTrackColor = Color.LightGray,
                    disabledInactiveTickColor = Color.LightGray
                )
            )
        }
    }
}

// ============================================
// SECTION 6: PROGRESS INDICATORS
// ============================================
@Composable
fun ProgressIndicatorsSection() {
    SectionContainer(title = "Progress Indicators") {

        // Circular Progress Indicator
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 4.dp
            )

            CircularProgressIndicator(
                progress = { 0.7f },
                modifier = Modifier.size(40.dp),
                color = Color(0xFF4CAF50),
                strokeWidth = 6.dp
            )

            Text("Loading...")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Linear Progress Indicator
        Column {
            Text("Linear Progress:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { 0.65f },
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFFF5722),
                trackColor = Color(0xFFFFCCBC)
            )
        }
    }
}

// ============================================
// SECTION 7: HORIZONTAL SCROLLING (LazyRow)
// ============================================
@Composable
fun HorizontalScrollSection() {
    SectionContainer(title = "Horizontal Scrolling - LazyRow") {

        // LazyRow with all parameters
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            reverseLayout = false,
            userScrollEnabled = true
        ) {
            items(15) { index ->
                Card(
                    modifier = Modifier
                        .size(width = 120.dp, height = 160.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(
                            red = (index * 20) % 255,
                            green = (index * 40) % 255,
                            blue = (index * 60) % 255
                        )
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Item ${index + 1}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Regular horizontal scroll with Row
        Text("Regular Row with Horizontal Scroll:", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .background(Color(0xFFF5F5F5))
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(10) { index ->
                Surface(
                    modifier = Modifier.size(80.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "${index + 1}")
                    }
                }
            }
        }
    }
}

// ============================================
// SECTION 8: BOX LAYOUT WITH OVERLAYS
// ============================================
@Composable
fun BoxLayoutSection() {
    SectionContainer(title = "Box Layout - Stacking & Overlays") {

        // Box with all alignment demonstrations
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF667EEA),
                            Color(0xFF764BA2)
                        )
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Background layer
            Text(
                text = "Background",
                modifier = Modifier.align(Alignment.TopStart),
                color = Color.White.copy(alpha = 0.5f)
            )

            // Center content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                    tint = Color.Yellow
                )
                Text(
                    text = "Centered Content",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            // Overlay badge
            Surface(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(40.dp),
                shape = CircleShape,
                color = Color.Red
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "99+",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Bottom action
            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text("Action")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Profile card example using Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            // Background image placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFF6B6B), Color(0xFFFFE66D))
                        )
                    )
            )

            // Profile card
            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Avatar
                    Surface(
                        modifier = Modifier
                            .size(80.dp)
                            .offset(y = (-40).dp),
                        shape = CircleShape,
                        color = Color(0xFF6200EE),
                        border = BorderStroke(4.dp, Color.White),
                        shadowElevation = 8.dp
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier = Modifier.size(48.dp),
                                tint = Color.White
                            )
                        }
                    }

                    Text(
                        text = "John Doe",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Android Developer",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

// ============================================
// SECTION 9: COMPLEX ROW LAYOUTS
// ============================================
@Composable
fun ComplexRowLayoutSection() {
    SectionContainer(title = "Complex Row Layouts") {

        // Row with weight distribution
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
                    .background(Color(0xFFE3F2FD), RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Weight 1")
            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .height(60.dp)
                    .background(Color(0xFFC5CAE9), RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Weight 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
                    .background(Color(0xFF9FA8DA), RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Weight 1")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Row with different arrangements
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Arrangement.Start:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            DemoRow(Arrangement.Start)

            Text("Arrangement.Center:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            DemoRow(Arrangement.Center)

            Text("Arrangement.End:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            DemoRow(Arrangement.End)

            Text("Arrangement.SpaceBetween:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            DemoRow(Arrangement.SpaceBetween)

            Text("Arrangement.SpaceAround:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            DemoRow(Arrangement.SpaceAround)

            Text("Arrangement.SpaceEvenly:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            DemoRow(Arrangement.SpaceEvenly)
        }
    }
}

@Composable
fun DemoRow(arrangement: Arrangement.Horizontal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF3E0))
            .padding(vertical = 8.dp),
        horizontalArrangement = arrangement
    ) {
        repeat(3) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFFF9800), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("${it + 1}", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// ============================================
// SECTION 10: TAB LAYOUT
// ============================================
@Composable
fun TabLayoutSection(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    SectionContainer(title = "Tab Layout") {

        val tabs = listOf("Home", "Profile", "Settings")

        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            indicator = { },
            divider = { }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { onTabSelected(index) },
                    text = { Text(title) },
                    icon = {
                        Icon(
                            imageVector = when (index) {
                                0 -> Icons.Default.Home
                                1 -> Icons.Default.Person
                                else -> Icons.Default.Settings
                            },
                            contentDescription = null
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tab content
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Content for ${tabs[selectedTab]} tab",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

// ============================================
// SECTION 11: LIST ITEMS
// ============================================
@Composable
fun ListItemsSection() {
    SectionContainer(title = "List Items") {

        val items = listOf(
            "Inbox" to Icons.Default.Home,
            "Starred" to Icons.Default.Star,
            "Sent" to Icons.Default.Share,
            "Drafts" to Icons.Default.Edit
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items.forEach { (title, icon) ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Column {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "Subtitle text",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                            }
                        }
                        Text(
                            text = "5",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

// ============================================
// SECTION 12: BADGE COMPONENTS
// ============================================
@Composable
fun BadgeComponentsSection() {
    SectionContainer(title = "Badge Components") {

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Badge with content
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("99+")
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            // Simple badge
            BadgedBox(
                badge = {
                    Badge(containerColor = Color(0xFF4CAF50))
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            // Badge with custom content
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = Color(0xFFFF9800),
                        contentColor = Color.White
                    ) {
                        Text("New")
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

// ============================================
// SECTION 13: DIVIDERS
// ============================================
@Composable
fun DividersSection() {
    SectionContainer(title = "Dividers") {

        Text("Item 1")

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.LightGray
        )

        Text("Item 2")

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.primary
        )

        Text("Item 3")

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 4.dp,
            color = Color(0xFFFF5722)
        )

        Text("Item 4")
    }
}

// ============================================
// DRAWER CONTENT
// ============================================
@Composable
fun DrawerContent(onCloseDrawer: () -> Unit) {
    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.75f)
    ) {
        // Drawer Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF6200EE),
                            Color(0xFF3700B3)
                        )
                    )
                )
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Column {
                Surface(
                    modifier = Modifier.size(64.dp),
                    shape = CircleShape,
                    color = Color.White
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(0xFF6200EE)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "John Doe",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "john.doe@example.com",
                    color = Color.White.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Drawer Items
        val drawerItems = listOf(
            "Home" to Icons.Default.Home,
            "Profile" to Icons.Default.Person,
            "Settings" to Icons.Default.Settings,
            "Favorites" to Icons.Default.Favorite,
            "Share" to Icons.Default.Share
        )

        drawerItems.forEach { (title, icon) ->
            NavigationDrawerItem(
                label = { Text(title) },
                selected = false,
                onClick = { onCloseDrawer() },
                icon = { Icon(icon, contentDescription = null) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        NavigationDrawerItem(
            label = { Text("Logout") },
            selected = false,
            onClick = { onCloseDrawer() },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

// ============================================
// TOP BAR
// ============================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSection(onMenuClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Best Practice Screen",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open drawer"
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(onClick = { }) {
                BadgedBox(
                    badge = {
                        Badge { Text("3") }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Notifications"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

// ============================================
// BOTTOM NAVIGATION
// ============================================
@Composable
fun BottomNavigationSection() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(
        "Home" to Icons.Default.Home,
        "Search" to Icons.Default.Search,
        "Favorites" to Icons.Default.Favorite,
        "Profile" to Icons.Default.Person
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        items.forEachIndexed { index, (label, icon) ->
            NavigationBarItem(
                icon = {
                    if (index == 2) {
                        BadgedBox(badge = { Badge { Text("2") } }) {
                            Icon(icon, contentDescription = label)
                        }
                    } else {
                        Icon(icon, contentDescription = label)
                    }
                },
                label = { Text(label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

// ============================================
// DIALOG SECTION
// ============================================
@Composable
fun DialogSection(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color(0xFFE91E63),
                modifier = Modifier.size(48.dp)
            )
        },
        title = {
            Text(
                text = "Dialog Title",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(
                text = "This is a dialog demonstrating all parameters. " +
                        "It has an icon, title, text content, and action buttons. " +
                        "You can customize colors, shapes, and behavior.",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        },
        containerColor = MaterialTheme.colorScheme.surface,
        iconContentColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
        textContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        shape = RoundedCornerShape(24.dp),
        tonalElevation = 6.dp
    )
}

// ============================================
// SECTION CONTAINER (Reusable Component)
// ============================================
@Composable
fun SectionContainer(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            content()
        }
    }
}

