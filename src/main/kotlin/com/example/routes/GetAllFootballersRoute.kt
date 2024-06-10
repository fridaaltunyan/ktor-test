package com.example.routes

import com.example.data.model.ApiResponse
import com.example.data.repositories.FootballerRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllFootballers() {
    val footballerRepository: FootballerRepository by inject()
    get("/footballers/all") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            println("NEW PAGE: $page")
            require(page in 1..5)

            val apiResponse = footballerRepository.getAllFootballers(page = page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Allowed."),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Footballers not Found."),
                status = HttpStatusCode.NotFound
            )
        }
    }
}