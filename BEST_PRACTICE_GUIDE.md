# Jetpack Compose Layout Hierarchy (Best Practice)

Think of a screen as **5 structural layers**.

```
Activity / NavHost
    ↓
Scaffold (screen structure)
    ↓
Screen Container (Box / Column / Row)
    ↓
Section Layouts (Cards, Lists, Groups)
    ↓
UI Elements (Text, Image, Button, etc.)
```

Now let's break this down properly.

---

## 1. Root Layer — Activity / NavHost

This is where Compose starts.

In modern apps this is usually inside **Navigation**.

```kotlin
setContent {
    MyTheme {
        ProfileScreen()
    }
}
```

Or inside navigation:

```kotlin
NavHost(navController, startDestination = "profile") {
    composable("profile") {
        ProfileScreen()
    }
}
```

**Responsibility**
- Apply theme
- Setup navigation
- Call screen composable

You normally **don't place UI here**.

---

## 2. Screen Structure — `Scaffold`

This is the **recommended outer layout for almost every screen**.

It provides built-in Material layout slots.

```
Scaffold
├── TopBar
├── BottomBar
├── FloatingActionButton
├── Drawer
└── Content
```

Example:

```kotlin
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Profile") }) },
        floatingActionButton = { FloatingActionButton(onClick = {}) {} }
    ) { padding ->
        ProfileContent(
            modifier = Modifier.padding(padding)
        )
    }
}
```

**Important detail:**
```kotlin
Scaffold { paddingValues -> }
```

You **must pass padding to content** to avoid overlapping with top bars.

---

## 3. Screen Container — Layout Composables

Inside the scaffold **content block**, you define the layout structure.

These are the **main layout primitives**.

### Column

Vertical stacking.

```
Text
Text
Button
```

```kotlin
Column {
    Text("Name")
    Text("Email")
}
```

---

### Row

Horizontal layout.

```
Image  Text  Icon
```

```kotlin
Row {
    Image(...)
    Text("John")
}
```

---

### Box

Used for **stacking or overlays**.

Example:

```
Profile Image
    + Edit Icon on top
```

```kotlin
Box {
    Image(...)
    Icon(...)
}
```

---

### LazyColumn / LazyRow

For lists.

```
RecyclerView equivalent
```

```kotlin
LazyColumn {
    items(users) {
        UserItem(it)
    }
}
```

---

## 4. Section Layouts (Reusable UI Blocks)

This is where you group UI logically.

Examples:

```
Profile Header
Settings Section
Stats Section
Buttons Section
```

Example:

```kotlin
@Composable
fun ProfileHeader() {
    Row {
        Image(...)
        Column {
            Text("John Doe")
            Text("Android Developer")
        }
    }
}
```

Then inside screen:

```kotlin
Column {
    ProfileHeader()
    Spacer(modifier = Modifier.height(16.dp))
    ProfileStats()
}
```

---

## 5. UI Elements (Leaf Nodes)

These are the **actual components**.

Examples:

```
Text
Image
Button
Card
Surface
Icon
TextField
Checkbox
```

Example:

```kotlin
Text(
    text = "Hello",
    fontSize = 20.sp
)
```

---

## Surface (Material Container)

`Surface` is a **Material-aware container** used to hold other UI while applying:
- background/color from theme
- shape (rounded corners, circles, etc.)
- elevation (tonal + shadow)
- border
- optional click handling

Think of it as the base Material building block for many components (including how `Card` is conceptually built).

### When to use `Surface`
- You need a styled container but **don't need full Card behavior**.
- You want a clickable/tappable area with Material styling.
- You want to apply shape + elevation + color in one place.
- You want theme-friendly containers for rows, headers, chips, badges, avatars, etc.

### Key parameters
```kotlin
Surface(
    onClick = { },                 // optional
    shape = RoundedCornerShape(12.dp),
    color = MaterialTheme.colorScheme.surface,
    contentColor = MaterialTheme.colorScheme.onSurface,
    tonalElevation = 2.dp,
    shadowElevation = 4.dp,
    border = BorderStroke(1.dp, Color.Gray)
) {
    // Content
}
```

### `Surface` vs `Card` vs `Box`
- **Surface**: Material container primitive (color/shape/elevation/border/click).
- **Card**: Higher-level opinionated Material component for card-style UI.
- **Box**: Pure layout/stacking container; no Material styling by default.

### Is `Surface` like `FrameLayout` from XML?
Short answer: **No, not directly**.

- `FrameLayout` is mainly a **layout container** for stacking children.
- In Compose, the closest layout equivalent to `FrameLayout` is **`Box`**.
- `Surface` is a **Material-styled container** (theme-aware color, shape, elevation, border, click behavior).

Quick mapping:
- **`FrameLayout` -> `Box`** (layout/stacking)
- **`Surface` -> Material container wrapper**
- Use both together when needed: `Surface { Box { ... } }`

### Real examples in this project
- `ListItemsSection()` uses `Surface` for each list row container.
- `BoxLayoutSection()` uses `Surface` for badge/avatar style circular overlays.
- `DrawerContent()` uses `Surface` for the profile icon container.

---

## Full Realistic Example

Let's combine everything.

```kotlin
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(24.dp))
            ProfileStats()
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {}) {
                Text("Edit Profile")
            }
        }
    }
}
```

Hierarchy becomes:

```
Activity
└── ProfileScreen
    └── Scaffold
        ├── TopAppBar
        └── Content
            └── Column
                ├── ProfileHeader
                ├── ProfileStats
                └── Button
```

---

## When to Use Each Layout / Container

| Layout / Container | Use Case                                 |
| ------------------ | ---------------------------------------- |
| Scaffold           | Whole screen structure                   |
| Column             | Vertical stacking                        |
| Row                | Horizontal alignment                     |
| Box                | Overlapping / stacking                   |
| LazyColumn         | Scrollable lists                         |
| LazyRow            | Horizontal lists                         |
| Surface            | Material-styled wrapper for section/item |

---

## Why Your Texts Overlapped

Because Compose **does not position items automatically**.

Example:

```kotlin
Text("Hello")
Text("World")
```

They render **in the same coordinate (0,0)** unless inside a layout.

Correct:

```kotlin
Column {
    Text("Hello")
    Text("World")
}
```

---

## Golden Rule in Compose

Think like **UI Lego blocks**.

```
Screen
    ↓
Layout
    ↓
Section
    ↓
Components
```

Not like the old **deep XML nesting**.

---

## The 90% Real-World Compose Pattern

Most screens follow this structure:

```
Scaffold
    ↓
LazyColumn / Column
    ↓
Cards / Sections
    ↓
Rows / Columns
    ↓
Text / Icons / Images
```

---

## One More Pro Tip (Very Important)

Always structure screens like this:

```
Screen()
├── ScreenContent()
├── Header()
├── Section()
└── Item()
```

Never write **1000 lines inside one composable**.

Compose apps scale through **small reusable composables**.

---

## Next Topics to Master

If you're serious about **mastering Compose UI**, the **next 4 things you should understand deeply** are:

1️⃣ **Modifier system (most powerful concept)**
2️⃣ **Alignment & Arrangement**
3️⃣ **State & recomposition**
4️⃣ **Lazy layouts performance**

---

## BestPracticeScreen Overview

The `BestPracticeScreen.kt` file included in this project demonstrates:

### 1. **Proper Architecture (Layers)**
- Layer 1: Navigation Drawer (Side navigation)
- Layer 2: Scaffold (screen structure with top bar, bottom bar, FAB)
- Layer 3: LazyColumn (scrollable content container)
- Layers 4-5: Sections and UI elements

### 2. **All Major Components**
- **Text**: With all parameters demonstrated (color, fontSize, fontWeight, fontFamily, textDecoration, textAlign, lineHeight, etc.)
- **Buttons**: Filled, Outlined, Elevated, Text, Filled Tonal, Icon buttons
- **Cards**: Basic, Elevated, Outlined cards with custom colors and elevation
- **Surface**: Material container usage for list items, overlays, and profile/avatar sections
- **Input Fields**: TextField, OutlinedTextField with full parameter showcase
- **Selection**: Checkbox, Radio Button, Switch, Slider
- **Progress**: Circular and Linear progress indicators
- **Lists**: LazyColumn for vertical scrolling, LazyRow for horizontal scrolling
- **Layouts**: Column, Row, Box with various modifiers
- **Advanced**: Tabs, Navigation Drawer, Dialog, Badges, Dividers

### 3. **Modifier Chains**
Each major component demonstrates extensive modifier usage:
- `.fillMaxWidth()`, `.fillMaxSize()`
- `.padding()`, `.height()`, `.width()`
- `.background()`, `.border()`, `.shadow()`
- `.clip()`, `.alpha()`, `.scale()`, `.rotate()`
- `.clickable()`

### 4. **Material3 Design**
- Uses Material3 color scheme
- Proper elevation and shadow handling
- Correct padding and spacing
- Theme integration

### 5. **State Management**
- `remember` for local state
- `mutableStateOf`, `mutableIntStateOf`, `mutableFloatStateOf`
- Proper scope management with `rememberCoroutineScope()`

### 6. **Reusable Components**
- `SectionContainer` for grouping related components
- `TopBarSection`, `BottomNavigationSection`, `DrawerContent`
- Specialized sections for each UI category

---

## How to Use BestPracticeScreen

1. **Learn the Architecture**: Study how layers are nested
2. **Copy Patterns**: Copy code snippets from the sections you need
3. **Modify for Your Needs**: Adapt colors, text, and parameters
4. **Understand Modifiers**: See how modifier chains work together
5. **State Management**: Use the state examples as templates

---

## Common Patterns Used

### Pattern 1: Full-Featured Component
```kotlin
Text(
    text = "Complete Text Example",
    modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFE3F2FD), RoundedCornerShape(8.dp))
        .padding(16.dp)
        .border(2.dp, Color(0xFF1976D2), RoundedCornerShape(8.dp))
        .clickable { }
        .alpha(1f)
        .shadow(4.dp, RoundedCornerShape(8.dp)),
    color = Color(0xFF0D47A1),
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center,
    maxLines = 2
)
```

### Pattern 2: Section with Title and Content
```kotlin
Card {
    Column {
        Text("Section Title", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(12.dp))
        // Content here
    }
}
```

### Pattern 3: Layout with Spacing
```kotlin
Column(
    modifier = Modifier.padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    // Items automatically spaced
}
```

### Pattern 4: Surface as Reusable Material Wrapper
```kotlin
Surface(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(12.dp),
    color = MaterialTheme.colorScheme.surfaceVariant,
    tonalElevation = 2.dp,
    onClick = { /* Row click */ }
) {
    Row(modifier = Modifier.padding(16.dp)) {
        Icon(Icons.Default.Person, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Text("Profile")
    }
}
```

---

## Quick Reference

### Fill vs Wrap
- `.fillMaxWidth()` - Takes all available width
- `.fillMaxSize()` - Takes all space
- `.wrapContentSize()` - Takes only needed space
- `.size(width, height)` - Fixed size

### Arrangement (for layouts)
- `Arrangement.Start` - Items at start
- `Arrangement.Center` - Items centered
- `Arrangement.spacedBy(8.dp)` - Even spacing

### Alignment
- `Alignment.TopStart`, `Alignment.Center`, etc.
- `horizontalAlignment`, `verticalAlignment` in layouts

### Surface Quick Rules
- Use `Surface` when you need **Material container styling + content**.
- Prefer `Surface` over only `.background(...)` when you also need elevation/shape/click semantics.
- Use `Card` when the UI is explicitly card-like; use `Surface` for general wrappers.
- Use `Box` for stacking; combine with `Surface` when you also need Material styling.

---

## File Structure

```
BestPracticeScreen.kt
├── BestPracticeScreen()              [Main screen composable]
├── TextComponentsSection()            [Text with all parameters]
├── ButtonComponentsSection()          [All button types]
├── CardComponentsSection()            [Card variations]
├── InputComponentsSection()           [TextField variations]
├── SelectionComponentsSection()       [Checkbox, Radio, Switch]
├── ProgressIndicatorsSection()        [Progress bars]
├── HorizontalScrollSection()          [LazyRow example]
├── BoxLayoutSection()                 [Box with overlays]
├── ComplexRowLayoutSection()          [Complex Row layouts]
├── TabLayoutSection()                 [Tab layout]
├── ListItemsSection()                 [LazyColumn example]
├── BadgeComponentsSection()           [Badges]
├── DividersSection()                  [Dividers]
├── TopBarSection()                    [Top navigation bar]
├── DrawerContent()                    [Side drawer content]
├── BottomNavigationSection()          [Bottom navigation]
├── DialogSection()                    [AlertDialog]
└── SectionContainer()                 [Reusable container]
```

---

## Tips for Building Screens

1. **Start with Scaffold** - Don't skip this
2. **Use LazyColumn for scrolling** - Not Column for long lists
3. **Extract reusable composables** - Keep functions small
4. **Use modifier chains** - Stack modifiers for compound effects
5. **Remember state properly** - Use `remember` for local state
6. **Use Material3** - Follow design system guidelines
7. **Test with Preview** - Use `@Preview` annotation
8. **Handle padding** - Always use Scaffold's padding values

---

## ⚠️ Common Mistake: Duplicate Theme Wrapping

**DON'T DO THIS:**
```kotlin
// MainActivity
setContent {
    ComposeTheme {  // ✅ Theme here
        MyScreen()
    }
}

// MyScreen.kt
@Composable
fun MyScreen() {
    ComposeTheme {  // ❌ DON'T wrap again!
        Scaffold { ... }
    }
}
```

**DO THIS INSTEAD:**
```kotlin
// MainActivity
setContent {
    ComposeTheme {  // ✅ Theme ONLY at root
        MyScreen()
    }
}

// MyScreen.kt
@Composable
fun MyScreen() {
    // ✅ No theme wrapper needed
    Scaffold { ... }
}
```

**Why?**
- Theme should be applied **once at the root level** (Activity or NavHost)
- Screen composables inherit the theme automatically
- Duplicate wrapping is redundant and can cause confusion
- Keeps screens reusable and independent of theming

**Navigation Example:**
```kotlin
setContent {
    ComposeTheme {  // ✅ Theme once here
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen() }  // No theme wrapper
            composable("profile") { ProfileScreen() }  // No theme wrapper
        }
    }
}
```

---

## ⚠️ Common Mistake: Using only `background` when `Surface` is needed

**Problem:**
Using only `Modifier.background(...)` for tappable or elevated containers.

```kotlin
Row(
    modifier = Modifier
        .background(Color.White)
        .clickable { }
)
```

This works visually, but you miss Material container behavior consistency.

**Better:**
```kotlin
Surface(
    onClick = { },
    shape = RoundedCornerShape(12.dp),
    color = MaterialTheme.colorScheme.surface,
    tonalElevation = 2.dp
) {
    Row(modifier = Modifier.padding(16.dp)) {
        Text("Item")
    }
}
```

**Why this is better:**
- Keeps styling consistent with Material3
- Centralizes shape/color/elevation/click in one composable
- Easier to reuse and maintain
