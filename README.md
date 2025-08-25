# CryptoTracker

A modern Android cryptocurrency tracking application built with Jetpack Compose, showcasing real-time cryptocurrency data visualization and tracking capabilities.

## Features

- **Real-time Cryptocurrency Data**: Track live cryptocurrency prices and market data
- **Detailed Coin Information**: View comprehensive details for each cryptocurrency including:
  - Current price
  - Market cap
  - 24-hour price changes
  - Price history visualization
- **Interactive Price Charts**: Dynamic line charts showing historical price data
- **Responsive UI**: Adaptive layout that works across different screen sizes
- **Dark/Light Theme Support**: Automatic theme switching based on system preferences

## Technology Stack

- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern UI toolkit for native Android UI
- **Coroutines**: For asynchronous programming
- **Koin**: Dependency injection
- **Ktor**: Networking client
- **Material Design 3**: Modern Android design system

## Architecture

The app follows Clean Architecture principles with a clear separation of concerns:

### Layers

- **Presentation**: Compose UI components and ViewModels
- **Domain**: Business logic and data models
- **Data**: Remote data source and repository implementations

### Key Components

- **CoinListScreen**: Main screen displaying list of cryptocurrencies
- **CoinDetailScreen**: Detailed view of selected cryptocurrency
- **LineChart**: Custom chart component for price history visualization
- **RemoteCoinDataSource**: Handles API communication
- **CoinListViewModel**: Manages UI state and business logic

## Features Implementation

### Real-time Price Tracking
- Implements real-time price updates using Kotlin Flow
- Displays price changes with intuitive up/down indicators

### Interactive Charts
- Custom-built line chart component for price history
- Interactive touch support for data point inspection
- Smooth animations and transitions

### Responsive Design
- Adaptive layout using Jetpack Compose's modern UI toolkit
- Support for different screen sizes and orientations
- Material Design 3 components for consistent UI/UX

### Error Handling
- Comprehensive network error handling
- User-friendly error messages
- Graceful degradation during network issues

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/ragul/cryptotracker/
│   │   │   ├── core/
│   │   │   │   ├── data/
│   │   │   │   ├── domain/
│   │   │   │   └── presentation/
│   │   │   ├── crypto/
│   │   │   │   ├── data/
│   │   │   │   ├── domain/
│   │   │   │   └── presentation/
│   │   │   └── ui/
│   │   │       └── theme/
│   │   └── res/
│   └── test/
└── build.gradle.kts
```

## Development Setup

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application

## Future Improvements

- Add cryptocurrency portfolio tracking
- Implement price alerts
- Add more detailed technical analysis tools
- Support for more cryptocurrencies
- Offline caching support
