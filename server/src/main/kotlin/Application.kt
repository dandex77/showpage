package com.showpage

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureTemplating()
    configureSockets()
    configureFrameworks()
    configureHTTP()
    configureRouting()
}
