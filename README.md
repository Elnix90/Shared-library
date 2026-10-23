# Shared UI


### A collection of shared UI element I use across my projects and libs, for them to be accessible easily and reliably

## Download

![Maven Central Version](https://img.shields.io/maven-central/v/io.github.elnix90.lock/compose-lock?style=for-the-badge)

### Setup - Version Catalog

Configure the dependency by adding it to your `libs.versions.toml` file as follows:

```toml
[versions]
#...
shared-library = "1.1.0"

[libraries]
#...
shared-library = { group = "io.github.elnix90.shared", name = "shared-library", version.ref = "shared-library" }
```

```kotlin

// Module build file
dependencies {
    // ...
    implementation(libs.compose.shared.library)
}
```





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
