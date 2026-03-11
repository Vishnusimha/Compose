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
- `CreatorStudioScreen.kt`
- `FoodDeliveryScreen.kt`
- `NetflixInspiredScreen.kt`
- `PinterestInspiredScreen.kt`
- `SideDrawerScreen.kt`
- `SpotifyInspiredScreen.kt`
- `SpotifyRealisticScreen.kt`
- `TravelPlannerScreen.kt`

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
| ✅ `FlowRow`            | Wrapping horizontal layout                    |      ✅ | `FoodDeliveryScreen.kt`                                                                                                                   |
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
| ✅ `BasicText`      | Low-level text composable            |      ✅ | `FoodDeliveryScreen.kt`      |
| ✅ `BasicTextField` | Low-level text input composable      |      ✅ | `FoodDeliveryScreen.kt`      |

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
| ✅ `ExtendedFloatingActionButton` | FAB with icon + text             |      ✅ | `TravelPlannerScreen.kt`                                                      |
| ✅ `AssistChip`                   | Small assist/action chip         |      ✅ | `PinterestInspiredScreen.kt`                                                 |
| ✅ `FilterChip`                   | Selectable filter chip           |      ✅ | `FoodDeliveryScreen.kt`                                                       |
| ✅ `SuggestionChip`               | Small suggestion action          |      ✅ | `FoodDeliveryScreen.kt`                                                       |
| ✅ `InputChip`                    | Chip with dismiss/input behavior |      ✅ | `FoodDeliveryScreen.kt`                                                       |
| ✅ `SegmentedButton`              | Segmented selection button       |      ✅ | `BestPracticeScreen.kt`                                                      |

---

## 5) Text input and form controls

| UI element                 | What it is used for           | Status | Example file(s)         |
|----------------------------|-------------------------------|-------:|-------------------------|
| ✅ `TextField`              | Filled Material text input    |      ✅ | `BestPracticeScreen.kt` |
| ✅ `OutlinedTextField`      | Outlined Material text input  |      ✅ | `BestPracticeScreen.kt` |
| ⬜ `SecureTextField`        | Password-style secure input   |      ⬜ | Not found               |
| ⬜ `SearchBar`              | Search UI container           |      ⬜ | Not found               |
| ✅ `DropdownMenu`           | Menu anchored to a trigger    |      ✅ | `FoodDeliveryScreen.kt` |
| ✅ `ExposedDropdownMenuBox` | Text field + dropdown pattern |      ✅ | `FoodDeliveryScreen.kt` |
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
| ✅ `RangeSlider`      | Two-thumb slider            |      ✅ | `TravelPlannerScreen.kt` |
| ✅ `TriStateCheckbox` | Three-state checkbox        |      ✅ | `TravelPlannerScreen.kt` |

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
| ✅ `CenterAlignedTopAppBar` | Center-aligned top bar          |      ✅ | `FoodDeliveryScreen.kt`                                                                                   |
| ✅ `BottomSheetScaffold`    | Screen with bottom sheet layout |      ✅ | `TravelPlannerScreen.kt`                                                                                  |
| ✅ `ModalBottomSheet`       | Modal bottom sheet              |      ✅ | `CreatorStudioScreen.kt`                                                                                  |
| ✅ `NavigationRail`         | Side navigation rail            |      ✅ | `TravelPlannerScreen.kt`                                                                                  |
| ✅ `NavigationRailItem`     | Item inside navigation rail     |      ✅ | `TravelPlannerScreen.kt`                                                                                  |
| ✅ `Pager`                  | Horizontal pager/swipe pages    |      ✅ | `CreatorStudioScreen.kt`                                                                                  |

---

## 8) Feedback, progress, and messaging

| UI element                    | What it is used for          | Status | Example file(s)         |
|-------------------------------|------------------------------|-------:|-------------------------|
| ✅ `CircularProgressIndicator` | Circular loading/progress    |      ✅ | `BestPracticeScreen.kt` |
| ✅ `LinearProgressIndicator`   | Linear loading/progress      |      ✅ | `BestPracticeScreen.kt` |
| ✅ `AlertDialog`               | Modal dialog                 |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Badge`                     | Small count/status indicator |      ✅ | `BestPracticeScreen.kt` |
| ✅ `BadgedBox`                 | Wrap content with badge      |      ✅ | `BestPracticeScreen.kt` |
| ✅ `Snackbar`                  | Temporary message at bottom  |      ✅ | `CreatorStudioScreen.kt` |
| ✅ `SnackbarHost`              | Host for snackbars           |      ✅ | `CreatorStudioScreen.kt` |
| ⬜ `TooltipBox`                | Tooltip container            |      ⬜ | Not found               |
| ⬜ `PullToRefreshBox`          | Pull to refresh container    |      ⬜ | Not found               |

---

## 9) Dividers and separators

| UI element            | What it is used for       | Status | Example file(s)         |
|-----------------------|---------------------------|-------:|-------------------------|
| ✅ `HorizontalDivider` | Horizontal separator line |      ✅ | `BestPracticeScreen.kt` |
| ✅ `VerticalDivider`   | Vertical separator line   |      ✅ | `TravelPlannerScreen.kt` |

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
| ✅ `verticalScroll`                  | Manual vertical scroll    |      ✅ | `FoodDeliveryScreen.kt` |
| ✅ `draggable`                       | Drag interaction          |      ✅ | `CreatorStudioScreen.kt` |
| ⬜ `swipeable` / `anchoredDraggable` | Swipe-based interaction   |      ⬜ | Not found               |

---

## 11) Quick summary of what is already covered in this package

### Fully demonstrated well

- ✅ Layouts: `Box`, `Column`, `Row`, `LazyColumn`, `LazyRow`, `LazyVerticalGrid`
- ✅ Material structure: `Scaffold`, `TopAppBar`, `Surface`, `Card`
- ✅ Buttons: `Button`, `OutlinedButton`, `ElevatedButton`, `TextButton`, `FilledTonalButton`,
  `IconButton`, `FloatingActionButton`, `ExtendedFloatingActionButton`
- ✅ Inputs: `TextField`, `OutlinedTextField`, `DropdownMenu`, `ExposedDropdownMenuBox`
- ✅ Selection: `Checkbox`, `Switch`, `RadioButton`, `Slider`, `RangeSlider`, `TriStateCheckbox`
- ✅ Feedback: `AlertDialog`, `Badge`, `CircularProgressIndicator`, `LinearProgressIndicator`,
  `Snackbar`, `SnackbarHost`
- ✅ Navigation: drawer, bottom navigation, top bar, tabs, navigation rail, modal bottom sheet,
  pager
- ✅ Media and low-level: `Icon`, `Image`, `AsyncImage`, `BasicText`, `BasicTextField`

### Good next items to add if you want to learn more

- ⬜ `SearchBar`
- ⬜ `DatePicker`
- ⬜ `TimePicker`
- ⬜ `DateRangePicker`
- ⬜ `TooltipBox`
- ⬜ `PullToRefreshBox`

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
| `CreatorStudioScreen.kt`     | Creator dashboard UI with pager, snackbar host, draggable scrubber, modal bottom sheet                                   |
| `FoodDeliveryScreen.kt`      | Food app UI with center top bar, chips, exposed dropdown, and low-level text APIs                                         |
| `NetflixInspiredScreen.kt`   | Streaming app style UI, top app bar, hero banner, lazy content rows, cards                                               |
| `PinterestInspiredScreen.kt` | Grid layout, chip filters, image cards, staggered visual idea                                                            |
| `SideDrawerScreen.kt`        | Drawer + scaffold + bottom app bar + FAB                                                                                 |
| `SpotifyInspiredScreen.kt`   | Simple Spotify-like layout                                                                                               |
| `SpotifyRealisticScreen.kt`  | More realistic Spotify-like layout with nested UI hierarchy comments                                                     |
| `TravelPlannerScreen.kt`     | Travel planning UI with BottomSheetScaffold, navigation rail, range slider, tri-state checkbox, and extended FAB        |

---

If you want, the next best improvement is to create the same kind of tracking README for the
`ui/theme` package and the `navigation` layer too.

