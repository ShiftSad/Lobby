plugins {
    id("com.github.johnrengelman.shadow") version "7.1.0"
    kotlin("plugin.serialization") version "1.8.10"
    kotlin("jvm") version "1.8.10"
    application
}

group = "tech.shiftmc.lobby"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Minestom:Minestom:ec8034750a") {
        exclude(group = "org.jboss.shrinkwrap.resolver", module = "shrinkwrap-resolver-depchain")
    }
    
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    
    // Coroutines
    implementation("com.github.shynixn.mccoroutine:mccoroutine-minestom-api:2.11.0")
    implementation("com.github.shynixn.mccoroutine:mccoroutine-minestom-core:2.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    
    // Logging
    implementation("org.tinylog:tinylog-api-kotlin:2.6.1")
    implementation("org.tinylog:tinylog-impl:2.6.1")
}

kotlin {
    jvmToolchain(17)
}

tasks.distZip {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.distTar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

application {
    mainClass.set("tech.shiftmc.lobby.LobbyExtension")
}
