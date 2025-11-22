plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

tasks.withType<ProcessResources> {
    val wasmOutput = file("../web/build/dist/wasmJs/productionExecutable")
    if (wasmOutput.exists()) {
        inputs.dir(wasmOutput)
    }

    from("../web/build/dist/wasmJs/productionExecutable") {
        into("web")
        include("**/*")
    }
    duplicatesStrategy = DuplicatesStrategy.WARN
}

dependencies {
    implementation(libs.ktor.server.html.builder)
    implementation(libs.kotlinx.html)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.htmx)
    implementation(libs.ktor.htmx.html)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.di)
    implementation(libs.ktor.server.sse)
    implementation(libs.ktor.server.openapi)
    implementation(libs.ktor.server.default.headers)
    implementation(libs.kotlin.asyncapi.ktor)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
