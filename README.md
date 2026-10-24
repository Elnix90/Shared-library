# Shared UI


### A collection of shared UI element I use across my projects and libs, for them to be accessible easily and reliably

## Download

![Maven Central Version](https://img.shields.io/maven-central/v/io.github.elnix90.shared/shared-ui?style=for-the-badge)

### Setup - Version Catalog

Configure the dependency by adding it to your `libs.versions.toml` file as follows:

```toml
[versions]
#...
shared-ui = "1.0.0"

[libraries]
#...
shared-ui = { group = "io.github.elnix90.shared", name = "shared-ui", version.ref = "shared-ui" }
```

```kotlin

// Module build file
dependencies {
    // ...
    implementation(libs.shared.ui)
}
```

## Contents

All APIs are under the `io.github.elnix90.shared` namespace (explicit API mode, so everything public is marked `public`):

- `shared.ui.base` - base Compose components (Spacer, BoxedIcon, AnimatedFab, scroll indicators), modifiers, haptic helpers, `rememberInteractionSource`, clipboard helpers, and `asState()`/`asMutableState()` for `SettingFlow`.
- `shared.ui.base.model` - `ToggleButtonOption` / `SelectButtonOption` contracts for connected button rows.
- `shared.ui.base.compositionlocals` - `LocalFullscreen`, `LocalDisableHapticFeedbackGlobally` (safe defaults, no crash when unset).
- `shared.ui.dragon` - the Dragon component set: `DragonButton`, `DragonIconButton`, `DragonSettingsGroup`, `DragonModalBottomSheet`, `SwitchRow`, `SliderWithLabel`, dialogs (`UserValidation`, `CustomAlertDialog`), expandable sections, text components, color pickers, and the `Setting()` composables wrapping `io.github.elnix90.settings` objects (Boolean/Int/Float/Dp/String/Enum).
- `shared.theme.AppObjectsColors` - Material component color providers using the custom color channels.
- `shared.ui.composition.LocalUseCustomColorChannels` - controls whether `AppObjectsColors` applies the custom channels; defaults to `true` and can be overridden by consumers.
- `shared.base.SettingFlow` - small `StateFlow`-backed setting holder with default/reset support.

UI strings inside the library are hardcoded English; icons are bundled drawables. Caller-provided `@StringRes`/`@DrawableRes` parameters are resolved against the consuming app at runtime.


## How to clone and add credentials

1. Generate the key

```bash
gpg --full-generate-key
```

- Select **RSA** and then 4096
- fill in the next prompts with what you need

2. Export the key to the `creds/` folder

```bash
gpg --armor --export-secret-key YOUR_KEY_ID > creds/private.asc
```

This will create or overwrite the file `creds/private.asc` in the repo (gitignored)

3. Export password to `creds/private.txt`

```bash
echo YOUR_PASSWORD > creds/passwd.txt
```

4. Generate Maven tokens

- Go to https://central.sonatype.com/usertoken and create a new token.
- Paste the username given to `creds/maven_username.txt`
- Paste the password given to `creds/maven_password.txt`

5. Export public keys

```bash
gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID
```

6. Verify export

```bash
gpg --keyserver keyserver.ubuntu.com --recv-keys YOUR_KEY_ID
```


7. you can now publish to maven by using `./gradlew publish` or triggering the workflow
