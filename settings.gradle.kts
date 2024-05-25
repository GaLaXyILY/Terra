pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net") {
            name = "Fabric Maven"
        }
        maven("https://maven.architectury.dev/") {
            name = "Architectury Maven"
        }
        maven("https://files.minecraftforge.net/maven/") {
            name = "Forge Maven"
        }
        maven("https://maven.quiltmc.org/repository/release/") {
            name = "Quilt"
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.7.0")
}

rootProject.name = "Terra"


fun includeImmediateChildren(dir: File, type: String) {
    dir.walkTopDown().maxDepth(1).forEach {
        if (!it.isDirectory || !File(it, "build.gradle.kts").exists()) return@forEach
        val addonDir = it.relativeTo(file(".")).path.replace("/", ":").replace("\\", ":")
        logger.info("Including $type directory \"$addonDir\" as subproject.")
        include(addonDir)
    }
}

includeImmediateChildren(file("common/api"), "API")
includeImmediateChildren(file("common/implementation"), "implementation")
includeImmediateChildren(file("common/addons"), "addon")

include(":platforms:bukkit")

// settings.gradle.kts
val isCiServer = System.getenv().containsKey("CI")
// Cache build artifacts, so expensive operations do not need to be re-computed
buildCache {
    local {
        isEnabled = !isCiServer
    }
}