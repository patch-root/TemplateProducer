# Template App for Amazon App Platform

This is a Kotlin Multiplatform template application built using the [Amazon App Platform](https://github.com/amzn/app-platform). It provides a modern, opinionated starting point for building scalable, testable, and multiplatform Compose applications.

## 🚀 Overview

This template demonstrates:

- ✅ Kotlin Multiplatform targeting Android, iOS, and WebAssembly (WASM)
- ✅ [App Platform](https://github.com/amzn/app-platform) conventions for DI, state, rendering, and navigation
- ✅ Molecule-powered presenters
- ✅ Scoped dependency injection using `@ContributesBinding`, `@SingleIn`, and `@ContributesRenderer`
- ✅ Reactive state with `StateFlow`
- ✅ Compose UI for Android and WASM
- ✅ Modular code structure for feature separation

## 🧱 Features

- `ExampleRepository`: A simple `StateFlow`-based repository that emits data
- `ExampleValueGenerator`: A scoped class that updates the repository with random values every 3 seconds
- `NavigationHeaderPresenter` and `NavigationDetailPresenter`: Molecule presenters driving the top bar and content UI
- `NavigationDetailRenderer`: A ComposeRenderer showing example state

## 📦 Modules

- `:app` – Main app entrypoint using Compose + App Platform
- `:core`, `:navigation`, `:login`, etc. – Example feature and infrastructure modules
- Structured for scalability and separation of concerns

## 🧪 Running the App

### Android

```bash
./gradlew :app:installDebug
```

### WASM (WebAssembly)

```bash
./gradlew :app:wasmJsBrowserDevelopmentRun
```

Then open the browser link shown in the terminal.

> 📝 Release WASM build:
> Run `./gradlew :app:wasmJsBrowserDistribution` and serve `build/dist/wasmJs/productionExecutable` with `npx http-server`.

## 🧰 Requirements

- JDK 17+
- Kotlin 2.0+
- Android Gradle Plugin 8.2+
- Gradle 8.0+
- Node.js (for WASM builds)
- Xcode (for iOS builds)

## 🔧 Configuration

You can modify app behavior by editing:

- `gradle.properties` – JVM and native memory settings
- `libs.versions.toml` – Centralized dependency version catalog
- `app/build.gradle` – Platform-specific targets and UI modules

## 🧪 Testing

This template includes support for:

- `:desktopTest`, `:androidInstrumentedTest`
- Composable robot tests (optional)
- Dependency-injected test environments using App Platform scopes

## 🤝 Contributing

Feel free to fork and adapt this template for your own projects. If you find bugs or improvements related to App Platform usage, consider opening issues or PRs against [amzn/app-platform](https://github.com/amzn/app-platform).

## 📄 License

This project inherits the license of the [Amazon App Platform](https://github.com/amzn/app-platform).
