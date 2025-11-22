package com.showpage

import com.asyncapi.kotlinasyncapi.context.service.AsyncApiExtension
import com.asyncapi.kotlinasyncapi.ktor.AsyncApiPlugin
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.di.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sse.*
import io.ktor.server.websocket.*
import io.ktor.sse.*
import io.ktor.websocket.*
import java.time.Duration
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds
import kotlinx.html.*

fun Application.configureRouting() {
    install(SSE)
    routing {
        sse("/hello") {
            send(ServerSentEvent("world"))
        }
        staticResources("/", "/web")
    }
}
