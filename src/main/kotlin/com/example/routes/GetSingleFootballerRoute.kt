package com.example.routes

import com.example.data.repositories.FootballerRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getSingleFootballer() {
    val heroRepository: FootballerRepository by inject()

    get("/footballer") {
        val name = call.request.queryParameters["name"]

        val apiResponse = heroRepository.getSingleFootballer(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}