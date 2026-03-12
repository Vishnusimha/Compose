# Presentation Package UI Reference

This folder contains learning/demo screens for Jetpack Compose.

## Status legend

- ✅ = used in at least one file under the `presentation` package
- ⬜ = not currently used in the `presentation` package

> Note: Jetpack Compose is a very large toolkit. 
> This README is a **practical, well-classified reference of the main UI elements you will use in real apps** across Compose Foundation + Material


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
- `UnusedComponentsShowcaseScreen.kt`

---

## 1) Layout primitives and screen structure

| UI element             | What it is used for                           | Status | Example file(s)                                                                                                                            | Real-world usage (when/why)                                                               |
|------------------------|-----------------------------------------------|-------:|--------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| ✅ `Box`                | Stacking/overlay layout                       |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`                                                          | Use for badges over images, floating buttons over content, and layered hero sections.     |
| ✅ `Column`             | Vertical layout                               |      ✅ | Almost all files                                                                                                                           | Default for forms/settings/detail screens where content flows top-to-bottom.              |
| ✅ `Row`                | Horizontal layout                             |      ✅ | Almost all files                                                                                                                           | Use for toolbars, action groups, and side-by-side metadata.                               |
| ✅ `Spacer`             | Space between composables                     |      ✅ | Almost all files                                                                                                                           | Prefer explicit spacing for readable and consistent layout rhythm.                        |
| ✅ `Scaffold`           | Full screen structure                         |      ✅ | All screen files                                                                                                                           | Use when screen needs app bar, snackbar host, FAB, bottom bars, or drawer integration.    |
| ✅ `LazyColumn`         | Vertical scrolling list                       |      ✅ | `BestPracticeScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt`, `SpotifyRealisticScreen.kt`, `SideDrawerScreen.kt`        | Best for long feeds/lists because only visible items are composed.                        |
| ✅ `LazyRow`            | Horizontal scrolling list                     |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt`, `SpotifyRealisticScreen.kt` | Use for carousels like "Continue watching" or "Recommended" rails.                        |
| ✅ `LazyVerticalGrid`   | Grid layout for lazy content                  |      ✅ | `PinterestInspiredScreen.kt`                                                                                                               | Use for gallery/catalog/product layouts where equal-width cards scale well.               |
| ⬜ `LazyHorizontalGrid` | Horizontal lazy grid                          |      ⬜ | Not currently used (only commented in `PinterestInspiredScreen.kt`)                                                                        | Useful for horizontally paged grids (e.g., TV dashboards with multi-row shelves).         |
| ✅ `FlowRow`            | Wrapping horizontal layout                    |      ✅ | `FoodDeliveryScreen.kt`                                                                                                                    | Use for dynamic chips/tags where item count and text length vary.                         |
| ✅ `FlowColumn`         | Wrapping vertical layout                      |      ✅ | `UnusedComponentsShowcaseScreen.kt`                                                                                                        | Use in narrow side panels to wrap actions top-to-bottom, then into next column.           |
| ✅ `BoxWithConstraints` | Responsive layout using available constraints |      ✅ | `UnusedComponentsShowcaseScreen.kt`                                                                                                        | Use when UI changes by available width/height (compact vs expanded layouts).              |
| ⬜ `ConstraintLayout`   | Constraint-based layout                       |      ⬜ | Not found                                                                                                                                  | Use for complex relation-heavy layouts where nested Rows/Columns become hard to maintain. |

---

## 2) Text and media

| UI element         | What it is used for                  | Status | Example file(s)                     | Real-world usage (when/why)                                                           |
|--------------------|--------------------------------------|-------:|-------------------------------------|---------------------------------------------------------------------------------------|
| ✅ `Text`           | Show text content                    |      ✅ | All files                           | Primary way to render labels, headings, helper text, and body copy.                   |
| ✅ `Icon`           | Show vector/material icons           |      ✅ | All files                           | Use for compact affordances (play, search, settings) and visual cues.                 |
| ✅ `Image`          | Show bitmap/vector drawable image    |      ✅ | `PinterestInspiredScreen.kt`        | Use for local app assets, placeholders, logos, and bundled illustrations.             |
| ✅ `AsyncImage`     | Load remote image (usually via Coil) |      ✅ | `PinterestInspiredScreen.kt`        | Use for CDN/API media with caching, placeholders, and async loading.                  |
| ✅ `Canvas`         | Custom drawing                       |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use for charts, waveforms, progress arcs, and custom brand graphics.                  |
| ✅ `BasicText`      | Low-level text composable            |      ✅ | `FoodDeliveryScreen.kt`             | Use when you need minimal overhead or custom text behavior outside Material defaults. |
| ✅ `BasicTextField` | Low-level text input composable      |      ✅ | `FoodDeliveryScreen.kt`             | Use for highly custom inputs like OTP, search bars, or branded edit fields.           |

---

## 3) Surface, cards, and containers

| UI element                        | What it is used for                           | Status | Example file(s)                                                                                               | Real-world usage (when/why)                                                                   |
|-----------------------------------|-----------------------------------------------|-------:|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| ✅ `Surface`                       | Material container with shape/color/elevation |      ✅ | `BestPracticeScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt`, `SpotifyRealisticScreen.kt`  | Use as themed section/background wrapper to apply color, shape, tonal elevation consistently. |
| ✅ `Card`                          | Standard card container                       |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`, `SpotifyInspiredScreen.kt` | Use for grouped content blocks users can scan and tap independently.                          |
| ✅ `ElevatedCard`                  | Card with stronger elevation                  |      ✅ | `BestPracticeScreen.kt`                                                                                       | Use when a card must stand out as the primary actionable item.                                |
| ✅ `OutlinedCard`                  | Card with border                              |      ✅ | `BestPracticeScreen.kt`                                                                                       | Use in dense UIs where elevation is subtle and borders separate items better.                 |
| ✅ `ListItem`                      | Ready-made Material list row                  |      ✅ | `UnusedComponentsShowcaseScreen.kt`                                                                           | Use for settings, menus, and inbox-style rows with leading/trailing slots.                    |
| ✅ `HorizontalMultiBrowseCarousel` | Material 3 carousel                           |      ✅ | `UnusedComponentsShowcaseScreen.kt`                                                                           | Use for media/product browsing where partial next items hint scroll direction.                |
| ✅ `VerticalMultiBrowseCarousel`   | Vertical carousel (fallback demo pattern)     |      ✅ | `UnusedComponentsShowcaseScreen.kt`                                                                           | Use for editorial stacks or spotlight feeds where card preview depth improves discovery.      |

---

## 4) Buttons and action components

| UI element                       | What it is used for              | Status | Example file(s)                                                              | Real-world usage (when/why)                                                   |
|----------------------------------|----------------------------------|-------:|------------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| ✅ `Button`                       | Filled primary button            |      ✅ | `BestPracticeScreen.kt`, `NetflixInspiredScreen.kt`                          | Use for the highest-priority action in a section (submit, continue, pay).     |
| ✅ `OutlinedButton`               | Bordered button                  |      ✅ | `BestPracticeScreen.kt`                                                      | Use for secondary actions that should remain visible but less dominant.       |
| ✅ `ElevatedButton`               | Elevated action button           |      ✅ | `BestPracticeScreen.kt`                                                      | Use when action button sits on busy background and needs stronger separation. |
| ✅ `TextButton`                   | Text-only action button          |      ✅ | `BestPracticeScreen.kt`                                                      | Use for low-emphasis actions in dialogs, cards, and inline flows.             |
| ✅ `FilledTonalButton`            | Secondary/emphasis button        |      ✅ | `BestPracticeScreen.kt`                                                      | Use as middle emphasis between `Button` and `TextButton`.                     |
| ✅ `IconButton`                   | Clickable icon action            |      ✅ | All screen files                                                             | Use for compact toolbar/media actions where icon-only meaning is clear.       |
| ✅ `FloatingActionButton`         | Floating action button           |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `SideDrawerScreen.kt` | Use for screen-level primary action that should stay visible while scrolling. |
| ✅ `ExtendedFloatingActionButton` | FAB with icon + text             |      ✅ | `TravelPlannerScreen.kt`                                                     | Use when primary action needs label clarity (e.g., "Plan Trip").              |
| ✅ `AssistChip`                   | Small assist/action chip         |      ✅ | `PinterestInspiredScreen.kt`                                                 | Use for optional contextual quick actions (save, help, nearby).               |
| ✅ `FilterChip`                   | Selectable filter chip           |      ✅ | `FoodDeliveryScreen.kt`                                                      | Use for facet filtering in catalogs/search results (price, cuisine, rating).  |
| ✅ `SuggestionChip`               | Small suggestion action          |      ✅ | `FoodDeliveryScreen.kt`                                                      | Use to suggest frequent or AI-recommended actions/queries.                    |
| ✅ `InputChip`                    | Chip with dismiss/input behavior |      ✅ | `FoodDeliveryScreen.kt`                                                      | Use for selected entities/tokens (people, tags) with remove affordance.       |
| ✅ `SegmentedButton`              | Segmented selection button       |      ✅ | `BestPracticeScreen.kt`                                                      | Use for mutually exclusive view modes (day/week/month, list/grid/map).        |

---

## 5) Text input and form controls

| UI element                 | What it is used for           | Status | Example file(s)                     | Real-world usage (when/why)                                                    |
|----------------------------|-------------------------------|-------:|-------------------------------------|--------------------------------------------------------------------------------|
| ✅ `TextField`              | Filled Material text input    |      ✅ | `BestPracticeScreen.kt`             | Use for short/medium text entry in standard forms with Material styling.       |
| ✅ `OutlinedTextField`      | Outlined Material text input  |      ✅ | `BestPracticeScreen.kt`             | Use in dense forms where outline improves field boundary clarity.              |
| ✅ `SecureTextField`        | Password-style secure input   |      ✅ | `BestPracticeScreen.kt`             | Use for passwords, PINs, or sensitive tokens with hidden text behavior.        |
| ✅ `SearchBar`              | Search UI container           |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use for global content discovery and query-driven navigation.                  |
| ✅ `DropdownMenu`           | Menu anchored to a trigger    |      ✅ | `FoodDeliveryScreen.kt`             | Use for overflow actions and small contextual options from icon/text triggers. |
| ✅ `ExposedDropdownMenuBox` | Text field + dropdown pattern |      ✅ | `FoodDeliveryScreen.kt`             | Use for form selection inputs that should look like editable fields.           |
| ✅ `DatePicker`             | Date selection UI             |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use when a single date must be accurate (booking, deadline, DOB).              |
| ✅ `DateRangePicker`        | Date range selection UI       |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use for check-in/check-out, reports, analytics windows.                        |
| ✅ `TimePicker`             | Time selection UI             |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use when precise time matters (reminders, schedules, appointments).            |

---

## 6) Selection controls

| UI element           | What it is used for         | Status | Example file(s)          | Real-world usage (when/why)                                                 |
|----------------------|-----------------------------|-------:|--------------------------|-----------------------------------------------------------------------------|
| ✅ `Checkbox`         | Multi-select boolean option |      ✅ | `BestPracticeScreen.kt`  | Use for independent yes/no options where multiple can be selected together. |
| ✅ `Switch`           | On/off toggle               |      ✅ | `BestPracticeScreen.kt`  | Use for immediate settings toggles (notifications, dark mode, sync).        |
| ✅ `RadioButton`      | Single-select option        |      ✅ | `BestPracticeScreen.kt`  | Use when exactly one option must be chosen from a small set.                |
| ✅ `Slider`           | Single value slider         |      ✅ | `BestPracticeScreen.kt`  | Use for continuous value tuning like volume, intensity, or distance.        |
| ✅ `RangeSlider`      | Two-thumb slider            |      ✅ | `TravelPlannerScreen.kt` | Use for min/max filtering such as budget, duration, or rating ranges.       |
| ✅ `TriStateCheckbox` | Three-state checkbox        |      ✅ | `TravelPlannerScreen.kt` | Use for parent-child selections to represent partially selected groups.     |

---

## 7) Navigation components

| UI element                 | What it is used for             | Status | Example file(s)                                                                                          | Real-world usage (when/why)                                                |
|----------------------------|---------------------------------|-------:|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| ✅ `TopAppBar`              | Top app bar/header              |      ✅ | `BestPracticeScreen.kt`, `PinterestInspiredScreen.kt`, `NetflixInspiredScreen.kt`, `SideDrawerScreen.kt` | Use as standard screen header with title, navigation, and key actions.     |
| ✅ `NavigationBar`          | Bottom navigation container     |      ✅ | `BestPracticeScreen.kt`                                                                                  | Use for 3-5 top-level destinations in phone apps.                          |
| ✅ `NavigationBarItem`      | Bottom navigation item          |      ✅ | `BestPracticeScreen.kt`                                                                                  | Use per destination with icon/label and selected state feedback.           |
| ✅ `BottomAppBar`           | Bottom app bar                  |      ✅ | `SideDrawerScreen.kt`                                                                                    | Use for persistent bottom actions, often with a centered FAB.              |
| ✅ `ModalNavigationDrawer`  | Side drawer container           |      ✅ | `BestPracticeScreen.kt`, `SideDrawerScreen.kt`                                                           | Use for larger navigation sets or account/settings shortcuts.              |
| ✅ `ModalDrawerSheet`       | Drawer panel content            |      ✅ | `BestPracticeScreen.kt`, `SideDrawerScreen.kt`                                                           | Use to structure drawer sections, headers, and grouped actions.            |
| ✅ `NavigationDrawerItem`   | Item inside drawer              |      ✅ | `BestPracticeScreen.kt`                                                                                  | Use for each drawer destination with active-state highlight.               |
| ✅ `TabRow`                 | Horizontal tab container        |      ✅ | `BestPracticeScreen.kt`                                                                                  | Use for sibling content categories on the same hierarchy level.            |
| ✅ `Tab`                    | Single tab item                 |      ✅ | `BestPracticeScreen.kt`                                                                                  | Use to switch content panes quickly without full screen navigation.        |
| ✅ `CenterAlignedTopAppBar` | Center-aligned top bar          |      ✅ | `FoodDeliveryScreen.kt`                                                                                  | Use when brand/title prominence is more important than dense actions.      |
| ✅ `BottomSheetScaffold`    | Screen with bottom sheet layout |      ✅ | `TravelPlannerScreen.kt`                                                                                 | Use for map+details, player+queue, or summary panels that expand/collapse. |
| ✅ `ModalBottomSheet`       | Modal bottom sheet              |      ✅ | `CreatorStudioScreen.kt`                                                                                 | Use for short-lived task flows (filters, share actions, pickers).          |
| ✅ `NavigationRail`         | Side navigation rail            |      ✅ | `TravelPlannerScreen.kt`                                                                                 | Use on tablets/desktop layouts where side nav improves reachability.       |
| ✅ `NavigationRailItem`     | Item inside navigation rail     |      ✅ | `TravelPlannerScreen.kt`                                                                                 | Use per rail destination with compact icon-first navigation.               |
| ✅ `Pager`                  | Horizontal pager/swipe pages    |      ✅ | `CreatorStudioScreen.kt`                                                                                 | Use for swipeable onboarding, media stories, and category pages.           |

---

## 8) Feedback, progress, and messaging

| UI element                    | What it is used for          | Status | Example file(s)                     | Real-world usage (when/why)                                                    |
|-------------------------------|------------------------------|-------:|-------------------------------------|--------------------------------------------------------------------------------|
| ✅ `CircularProgressIndicator` | Circular loading/progress    |      ✅ | `BestPracticeScreen.kt`             | Use for indeterminate waiting states inside compact areas.                     |
| ✅ `LinearProgressIndicator`   | Linear loading/progress      |      ✅ | `BestPracticeScreen.kt`             | Use for page-level progress and long operations with visible progression.      |
| ✅ `AlertDialog`               | Modal dialog                 |      ✅ | `BestPracticeScreen.kt`             | Use for critical confirmations, permission rationale, and destructive actions. |
| ✅ `Badge`                     | Small count/status indicator |      ✅ | `BestPracticeScreen.kt`             | Use for unread counts or small status indicators near nav/actions.             |
| ✅ `BadgedBox`                 | Wrap content with badge      |      ✅ | `BestPracticeScreen.kt`             | Use when badge must be anchored to icons like cart, inbox, notifications.      |
| ✅ `Snackbar`                  | Temporary message at bottom  |      ✅ | `CreatorStudioScreen.kt`            | Use for transient feedback and undo actions without blocking user flow.        |
| ✅ `SnackbarHost`              | Host for snackbars           |      ✅ | `CreatorStudioScreen.kt`            | Use in `Scaffold` to queue and present snackbar messages reliably.             |
| ✅ `TooltipBox`                | Tooltip container            |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use for discoverability when icon meaning is not obvious.                      |
| ✅ `PullToRefreshBox`          | Pull to refresh container    |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use on feed/list screens where users expect manual refresh gesture.            |

---

## 9) Dividers and separators

| UI element            | What it is used for       | Status | Example file(s)          | Real-world usage (when/why)                                              |
|-----------------------|---------------------------|-------:|--------------------------|--------------------------------------------------------------------------|
| ✅ `HorizontalDivider` | Horizontal separator line |      ✅ | `BestPracticeScreen.kt`  | Use between list/settings rows to improve scanability in dense sections. |
| ✅ `VerticalDivider`   | Vertical separator line   |      ✅ | `TravelPlannerScreen.kt` | Use to separate side-by-side controls or grouped summary values.         |

---

## 10) Useful low-level and foundation interaction APIs

These are not always called “UI elements” in the same way as Material components, but they are
important building blocks used heavily in Compose UI.

| UI element / API                    | What it is used for       | Status | Example file(s)                     | Real-world usage (when/why)                                               |
|-------------------------------------|---------------------------|-------:|-------------------------------------|---------------------------------------------------------------------------|
| ✅ `Modifier.clickable`              | Make UI tappable          |      ✅ | `BestPracticeScreen.kt`             | Use to attach taps to non-button surfaces (cards, rows, custom elements). |
| ✅ `Modifier.background`             | Paint background          |      ✅ | All files                           | Use for section emphasis, skeleton states, and custom theme layers.       |
| ✅ `Modifier.border`                 | Add border                |      ✅ | `BestPracticeScreen.kt`             | Use to indicate boundaries, focus, or selected state without elevation.   |
| ✅ `Modifier.shadow`                 | Add shadow                |      ✅ | `BestPracticeScreen.kt`             | Use to elevate custom components where `Card`/`Surface` are not used.     |
| ✅ `Modifier.padding`                | Internal/external spacing |      ✅ | All files                           | Use to enforce touch-friendly spacing and consistent visual rhythm.       |
| ✅ `Modifier.size`                   | Fixed size                |      ✅ | All files                           | Use for predictable icon/thumb/avatar dimensions and gesture targets.     |
| ✅ `horizontalScroll`                | Manual horizontal scroll  |      ✅ | `BestPracticeScreen.kt`             | Use for lightweight chip/action rows when lazy behavior is unnecessary.   |
| ✅ `verticalScroll`                  | Manual vertical scroll    |      ✅ | `FoodDeliveryScreen.kt`             | Use for shorter static screens with one content column.                   |
| ✅ `draggable`                       | Drag interaction          |      ✅ | `CreatorStudioScreen.kt`            | Use for free-form drag controls like scrubbers, sliders, and handles.     |
| ✅ `swipeable` / `anchoredDraggable` | Swipe-based interaction   |      ✅ | `UnusedComponentsShowcaseScreen.kt` | Use for anchored gestures (dismiss, reveal actions, snap states).         |

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

- ⬜ `LazyHorizontalGrid`
- ⬜ `ConstraintLayout`
- ⬜ Advanced `PullToRefreshBox` with data source integration

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

| File                                | Main things demonstrated                                                                                                                             |
|-------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| `BestPracticeScreen.kt`             | Broadest coverage: text, buttons, cards, inputs, selection, progress, tabs, drawer, navigation, dialog, badges, dividers                             |
| `CreatorStudioScreen.kt`            | Creator dashboard UI with pager, snackbar host, draggable scrubber, modal bottom sheet                                                               |
| `FoodDeliveryScreen.kt`             | Food app UI with center top bar, chips, exposed dropdown, and low-level text APIs                                                                    |
| `NetflixInspiredScreen.kt`          | Streaming app style UI, top app bar, hero banner, lazy content rows, cards                                                                           |
| `PinterestInspiredScreen.kt`        | Grid layout, chip filters, image cards, staggered visual idea                                                                                        |
| `SideDrawerScreen.kt`               | Drawer + scaffold + bottom app bar + FAB                                                                                                             |
| `SpotifyInspiredScreen.kt`          | Simple Spotify-like layout                                                                                                                           |
| `SpotifyRealisticScreen.kt`         | More realistic Spotify-like layout with nested UI hierarchy comments                                                                                 |
| `TravelPlannerScreen.kt`            | Travel planning UI with BottomSheetScaffold, navigation rail, range slider, tri-state checkbox, and extended FAB                                     |
| `UnusedComponentsShowcaseScreen.kt` | Missing-components lab: SearchBar, pickers, TooltipBox, PullToRefreshBox, swipeable, FlowColumn, BoxWithConstraints, Canvas, ListItem, and carousels |

---

