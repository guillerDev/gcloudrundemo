package com.leakingcode

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing

fun Routing.gets() {
    get("/hello") {
        call.respondText("Hi! ktor is running!")
    }

    get("/info") {
        call.respondText("Listening in port: ${System.getenv("PORT")}")
    }

    get("/properties") {
        call.respondText(System.getProperties().toString())
    }
}

fun Application.mainModule() {
    install(CallLogging)
    routing {
        gets()
    }
}
