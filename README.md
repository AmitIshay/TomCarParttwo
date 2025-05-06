# 🚗 TomCar Game - Android App

**TomCar** is an endless runner-style Android game where the player controls a car, dodges rocks, and collects coins to score points.

## 🎮 Game Description

- The player controls a car that moves between five lanes at the bottom of the screen.
- Rocks and coins fall from the top of the screen toward the bottom.
- Hitting a rock causes the player to lose a heart (life).
- Collecting coins increases the score.
- Passing rocks without hitting them also awards points.
- The game ends when all lives are lost.

## 📱 Technologies Used

- Java (Android)
- Android Studio
- Material Design Components
- Location Services (for getting player location)
- MediaPlayer (for crash sound effects)
- Vibrator (for vibration feedback on crash)
- CountDownTimer (for game loop timing)

## 🧠 Core Logic (GameManager)

- `moveLeft()` / `moveRight()` — Move the car between lanes.
- `startTime()` — Starts the game loop using a timer.
- `checkCrash()` — Checks if the car hit a rock.
- `checkCoinCrash()` — Checks if a coin was collected.
- `removeLastLine()` — Clears bottom-row elements.
- `newRockOrCoin()` — Adds a new rock or coin at the top row.
- `gameOverDialog()` — Dialog for entering player's name and saving the score.

## 💾 Player Data

- Player name is entered at game over.
- Score and geographic location are saved.
- Data is passed to `RecordTableActivity` to display high scores.

## 📸 Main Screens

- **MainActivity**: Game menu with mode selection (normal/fast).
- **GameActivity**: Main gameplay screen.
- **RecordTableActivity**: Scoreboard with top players and locations.
- **MapFragment**: Shows players' locations on a map.

## ⚙️ Requirements

- Minimum Android API level: 26 (Oreo) — due to `VibrationEffect` usage.
- Location permission (`ACCESS_FINE_LOCATION`) must be granted.

## 🛠️ Setup and Run

1. Open the project in Android Studio.
2. Enable location access in app permissions.
3. Run the game on an emulator or physical device with GPS enabled.


---

