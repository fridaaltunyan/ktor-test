package com.example.plugins

import com.example.routes.getAllFootballers
import com.example.routes.getSingleFootballer
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        getAllFootballers()
        getSingleFootballer()
    }
}
