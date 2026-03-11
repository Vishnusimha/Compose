# Presentation Package UI Reference

This folder contains learning/demo screens for Jetpack Compose.

## Status legend

- ✅ = used in at least one file under the `presentation` package
- ⬜ = not currently used in the `presentation` package

> Note: Jetpack Compose is a very large toolkit. This README is a **practical, well-classified
reference of the main UI elements you will use in real apps** across Compose Foundation + Material
3.

---

## Files in this package

- `BestPracticeScreen.kt`
- `NetflixInspiredScreen.kt`
- `PinterestInspiredScreen.kt`
- `SideDrawerScreen.kt`
- `SpotifyInspiredScreen.kt`
- `SpotifyRealisticScreen.kt`

---

## 1) Layout primitives and screen structure

| UI element             | What it is used for                           | Status | Example file(s)                                                                                                                            |
|------------------------|-----------------------------------------------|-------:|--------------------------------------------------------------------------------------------------------------------------------------------|
| ✅ `Box`                | Stacking/overlay layout                       |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`                                                          |
| ✅ `Column`             | Vertical layout                               |      ✅ | Almost all files                                                                                                                           |
| ✅ `Row`                | Horizontal layout                             |      ✅ | Almost all files                                                                                                                           |
| ✅ `Spacer`             | Space between composables                     |      ✅ | Almost all files                                                                                                                           |
| ✅ `Scaffold`           | Full screen structure                         |      ✅ | All screen files                                                                                                                           |
| ✅ `LazyColumn`         | Vertical scrolling list                       |      ✅ | `BestPracticeScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt`, `SpotifyRealisticScreen.kt`, `SideDrawerScreen.kt`        |
| ✅ `LazyRow`            | Horizontal scrolling list                     |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt`, `SpotifyRealisticScreen.kt` |
| ✅ `LazyVerticalGrid`   | Grid layout for lazy content                  |      ✅ | `PinterestInspiredScreen.kt`                                                                                                               |
| ⬜ `LazyHorizontalGrid` | Horizontal lazy grid                          |      ⬜ | Not currently used (only commented in `PinterestInspiredScreen.kt`)                                                                        |
| ⬜ `FlowRow`            | Wrapping horizontal layout                    |      ⬜ | Not found                                                                                                                                  |
| ⬜ `FlowColumn`         | Wrapping vertical layout                      |      ⬜ | Not found                                                                                                                                  |
| ⬜ `BoxWithConstraints` | Responsive layout using available constraints |      ⬜ | Not found                                                                                                                                  |
| ⬜ `ConstraintLayout`   | Constraint-based layout                       |      ⬜ | Not found                                                                                                                                  |

---

## 2) Text and media

| UI element         | What it is used for                  | Status | Example file(s)              |
|--------------------|--------------------------------------|-------:|------------------------------|
| ✅ `Text`           | Show text content                    |      ✅ | All files                    |
| ✅ `Icon`           | Show vector/material icons           |      ✅ | All files                    |
| ✅ `Image`          | Show bitmap/vector drawable image    |      ✅ | `PinterestInspiredScreen.kt` |
| ✅ `AsyncImage`     | Load remote image (usually via Coil) |      ✅ | `PinterestInspiredScreen.kt` |
| ⬜ `Canvas`         | Custom drawing                       |      ⬜ | Not found                    |
| ⬜ `BasicText`      | Low-level text composable            |      ⬜ | Not found                    |
| ⬜ `BasicTextField` | Low-level text input composable      |      ⬜ | Not found                    |

---

## 3) Surface, cards, and containers

| UI element                        | What it is used for                           | Status | Example file(s)                                                                                               |
|-----------------------------------|-----------------------------------------------|-------:|---------------------------------------------------------------------------------------------------------------|
| ✅ `Surface`                       | Material container with shape/color/elevation |      ✅ | `BestPracticeScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt`, `SpotifyRealisticScreen.kt`  |
| ✅ `Card`                          | Standard card container                       |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt` |
| ✅ `ElevatedCard`                  | Card with stronger elevation                  |      ✅ | `BestPracticeScreen.kt`                                                                                       |
| ✅ `OutlinedCard`                  | Card with border                              |      ✅ | `BestPracticeScreen.kt`                                                                                       |
| ⬜ `ListItem`                      | Ready-made Material list row                  |      ⬜ | Not found                                                                                                     |
| ⬜ `HorizontalMultiBrowseCarousel` | Material 3 carousel                           |      ⬜ | Not found                                                                                                     |
| ⬜ `VerticalMultiBrowseCarousel`   | Vertical carousel                             |      ⬜ | Not found                                                                                                     |

---

## 4) Buttons and action components

| UI element                       | What it is used for              | Status | Example file(s)                                                              |
|----------------------------------|----------------------------------|-------:|------------------------------------------------------------------------------|
| ✅ `Button`                       | Filled primary button            |      ✅ | `BestPracticeScreen.kt`, `NetflixInspiredScreen.kt`                          |
| ✅ `OutlinedButton`               | Bordered button                  |      ✅ | `BestPracticeScreen.kt`                                                      |
| ✅ `ElevatedButton`               | Elevated action button           |      ✅ | `BestPracticeScreen.kt`                                                      |
| ✅ `TextButton`                   | Text-only action button          |      ✅ | `BestPracticeScreen.kt`                                                      |
| ✅ `FilledTonalButton`            | Secondary/emphasis button        |      ✅ | `BestPracticeScreen.kt`                                                      |
| ✅ `IconButton`                   | Clickable icon action            |      ✅ | All screen files                                                             |
| ✅ `FloatingActionButton`         | Floating action button           |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `SideDrawerScreen.kt` |
| ⬜ `ExtendedFloatingActionButton` | FAB with icon + text             |      ⬜ | Not found                                                                    |
| ✅ `AssistChip`                   | Small assist/action chip         |      ✅ | `PinterestInspiredScreen.kt`                                                 |
| ⬜ `FilterChip`                   | Selectable filter chip           |      ⬜ | Not found                                                                    |
| ⬜ `SuggestionChip`               | Small suggestion action          |      ⬜ | Not found                                                                    |
| ⬜ `InputChip`                    | Chip with dismiss/input behavior |      ⬜ | Not found                                                                    |
| ⬜ `SegmentedButton`              | Segmented selection button       |      ⬜ | Not found                                                                    |

---

## 5) Text input and form controls

| UI element                 | What it is used for           | Status | Example file(s)         |
|----------------------------|-------------------------------|-------:|-------------------------|
| ✅ `TextField`              | Filled Material text input    |      ✅ | `BestPracticeScreen.kt` |
| ✅ `OutlinedTextField`      | Outlined Material text input  |      ✅ | `BestPracticeScreen.kt` |
| ⬜ `SecureTextField`        | Password-style secure input   |      ⬜ | Not found               |
| ⬜ `SearchBar`              | Search UI container           |      ⬜ | Not found               |
| ⬜ `DropdownMenu`           | Menu anchored to a trigger    |      ⬜ | Not found               |
| ⬜ `ExposedDropdownMenuBox` | Text field + dropdown pattern |      ⬜ | Not found               |
| ⬜ `DatePicker`             | Date selection UI             |      ⬜ | Not found               |
| ⬜ `DateRangePicker`        | Date range selection UI       |      ⬜ | Not found               |
| ⬜ `TimePicker`             | Time selection UI             |      ⬜ | Not found               |

---

## 6) Selection controls

| UI element           | What it is used for         | Status | Example file(s)         |
|----------------------|-----------------------------|-------:|-------------------------|
| ✅ `Checkbox`         | Multi-select boolean option |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Switch`           | On/off toggle               |      ✅ | `BestPracticeScreen.kt` |
| ✅ `RadioButton`      | Single-select option        |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Slider`           | Single value slider         |      ✅ | `BestPracticeScreen.kt` |
| ⬜ `RangeSlider`      | Two-thumb slider            |      ⬜ | Not found               |
| ⬜ `TriStateCheckbox` | Three-state checkbox        |      ⬜ | Not found               |

---

## 7) Navigation components

| UI element                 | What it is used for             | Status | Example file(s)                                                                                          |
|----------------------------|---------------------------------|-------:|----------------------------------------------------------------------------------------------------------|
| ✅ `TopAppBar`              | Top app bar/header              |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`, `SideDrawerScreen.kt` |
| ✅ `NavigationBar`          | Bottom navigation container     |      ✅ | `BestPracticeScreen.kt`                                                                                  |
| ✅ `NavigationBarItem`      | Bottom navigation item          |      ✅ | `BestPracticeScreen.kt`                                                                                  |
| ✅ `BottomAppBar`           | Bottom app bar                  |      ✅ | `SideDrawerScreen.kt`                                                                                    |
| ✅ `ModalNavigationDrawer`  | Side drawer container           |      ✅ | `BestPracticeScreen.kt`, `SideDrawerScreen.kt`                                                           |
| ✅ `ModalDrawerSheet`       | Drawer panel content            |      ✅ | `BestPracticeScreen.kt`, `SideDrawerScreen.kt`                                                           |
| ✅ `NavigationDrawerItem`   | Item inside drawer              |      ✅ | `BestPracticeScreen.kt`                                                                                  |
| ✅ `TabRow`                 | Horizontal tab container        |      ✅ | `BestPracticeScreen.kt`                                                                                  |
| ✅ `Tab`                    | Single tab item                 |      ✅ | `BestPracticeScreen.kt`                                                                                  |
| ⬜ `CenterAlignedTopAppBar` | Center-aligned top bar          |      ⬜ | Not found                                                                                                |
| ⬜ `BottomSheetScaffold`    | Screen with bottom sheet layout |      ⬜ | Not found                                                                                                |
| ⬜ `ModalBottomSheet`       | Modal bottom sheet              |      ⬜ | Not found                                                                                                |
| ⬜ `NavigationRail`         | Side navigation rail            |      ⬜ | Not found                                                                                                |
| ⬜ `NavigationRailItem`     | Item inside navigation rail     |      ⬜ | Not found                                                                                                |
| ⬜ `Pager`                  | Horizontal pager/swipe pages    |      ⬜ | Not found                                                                                                |

---

## 8) Feedback, progress, and messaging

| UI element                    | What it is used for          | Status | Example file(s)         |
|-------------------------------|------------------------------|-------:|-------------------------|
| ✅ `CircularProgressIndicator` | Circular loading/progress    |      ✅ | `BestPracticeScreen.kt` |
| ✅ `LinearProgressIndicator`   | Linear loading/progress      |      ✅ | `BestPracticeScreen.kt` |
| ✅ `AlertDialog`               | Modal dialog                 |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Badge`                     | Small count/status indicator |      ✅ | `BestPracticeScreen.kt` |
| ✅ `BadgedBox`                 | Wrap content with badge      |      ✅ | `BestPracticeScreen.kt` |
| ⬜ `Snackbar`                  | Temporary message at bottom  |      ⬜ | Not found               |
| ⬜ `SnackbarHost`              | Host for snackbars           |      ⬜ | Not found               |
| ⬜ `TooltipBox`                | Tooltip container            |      ⬜ | Not found               |
| ⬜ `PullToRefreshBox`          | Pull to refresh container    |      ⬜ | Not found               |

---

## 9) Dividers and separators

| UI element            | What it is used for       | Status | Example file(s)         |
|-----------------------|---------------------------|-------:|-------------------------|
| ✅ `HorizontalDivider` | Horizontal separator line |      ✅ | `BestPracticeScreen.kt` |
| ⬜ `VerticalDivider`   | Vertical separator line   |      ⬜ | Not found               |

---

## 10) Useful low-level and foundation interaction APIs

These are not always called “UI elements” in the same way as Material components, but they are
important building blocks used heavily in Compose UI.

| UI element / API                    | What it is used for       | Status | Example file(s)         |
|-------------------------------------|---------------------------|-------:|-------------------------|
| ✅ `Modifier.clickable`              | Make UI tappable          |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Modifier.background`             | Paint background          |      ✅ | All files               |
| ✅ `Modifier.border`                 | Add border                |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Modifier.shadow`                 | Add shadow                |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Modifier.padding`                | Internal/external spacing |      ✅ | All files               |
| ✅ `Modifier.size`                   | Fixed size                |      ✅ | All files               |
| ✅ `horizontalScroll`                | Manual horizontal scroll  |      ✅ | `BestPracticeScreen.kt` |
| ⬜ `verticalScroll`                  | Manual vertical scroll    |      ⬜ | Not found               |
| ⬜ `draggable`                       | Drag interaction          |      ⬜ | Not found               |
| ⬜ `swipeable` / `anchoredDraggable` | Swipe-based interaction   |      ⬜ | Not found               |

---

## 11) Quick summary of what is already covered in this package

### Fully demonstrated well

- ✅ Layouts: `Box`, `Column`, `Row`, `LazyColumn`, `LazyRow`, `LazyVerticalGrid`
- ✅ Material structure: `Scaffold`, `TopAppBar`, `Surface`, `Card`
- ✅ Buttons: `Button`, `OutlinedButton`, `ElevatedButton`, `TextButton`, `FilledTonalButton`,
  `IconButton`, `FloatingActionButton`
- ✅ Inputs: `TextField`, `OutlinedTextField`
- ✅ Selection: `Checkbox`, `Switch`, `RadioButton`, `Slider`
- ✅ Feedback: `AlertDialog`, `Badge`, `CircularProgressIndicator`, `LinearProgressIndicator`
- ✅ Navigation: drawer, bottom navigation, top bar, tabs
- ✅ Media: `Icon`, `Image`, styled `Text`

### Good next items to add if you want to learn more

- ⬜ `DropdownMenu`
- ⬜ `FilterChip`
- ⬜ `SuggestionChip`
- ⬜ `ExtendedFloatingActionButton`
- ⬜ `RangeSlider`
- ⬜ `Snackbar`
- ⬜ `ModalBottomSheet`
- ⬜ `SearchBar`
- ⬜ `DatePicker`
- ⬜ `TimePicker`
- ⬜ `NavigationRail`
- ⬜ `Pager`

---

## 12) Best learning order

If you are learning Compose, study in this order:

1. `Box`, `Row`, `Column`, `Spacer`
2. `Text`, `Icon`, `Image`
3. `Button`, `IconButton`, `Surface`, `Card`
4. `TextField`, `OutlinedTextField`
5. `Checkbox`, `Switch`, `RadioButton`, `Slider`
6. `LazyColumn`, `LazyRow`, `LazyVerticalGrid`
7. `Scaffold`, `TopAppBar`, `NavigationBar`, `ModalNavigationDrawer`
8. `AlertDialog`, `Badge`, progress indicators
9. Tabs, chips, grids, realistic app screens

---

## 13) Current package coverage by file

| File                         | Main things demonstrated                                                                                                 |
|------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `BestPracticeScreen.kt`      | Broadest coverage: text, buttons, cards, inputs, selection, progress, tabs, drawer, navigation, dialog, badges, dividers |
| `NetflixInspiredScreen.kt`   | Streaming app style UI, top app bar, hero banner, lazy content rows, cards                                               |
| `PinterestInspiredScreen.kt` | Grid layout, chip filters, image cards, staggered visual idea                                                            |
| `SideDrawerScreen.kt`        | Drawer + scaffold + bottom app bar + FAB                                                                                 |
| `SpotifyInspiredScreen.kt`   | Simple Spotify-like layout                                                                                               |
| `SpotifyRealisticScreen.kt`  | More realistic Spotify-like layout with nested UI hierarchy comments                                                     |

---

If you want, the next best improvement is to create the same kind of tracking README for the
`ui/theme` package and the `navigation` layer too.

