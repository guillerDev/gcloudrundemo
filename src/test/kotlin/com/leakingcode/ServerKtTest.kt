package com.leakingcode

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.Test
import kotlin.test.assertEquals

class ServerKtTest {

    @Test
    fun testStartStopServer() {
        val server = embeddedServer(
            factory = Jetty,
            port = 8080,
            module = Application::mainModule
        )
        server.start()
        server.stop(1000L, 1000L)
    }

    @Test
    fun testOK() {
        withTestApplication({
            mainModule()
        }) {
            with(handleRequest(HttpMethod.Get, "/hello")) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
