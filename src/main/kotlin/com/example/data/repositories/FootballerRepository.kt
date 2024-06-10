package com.example.data.repositories

import com.example.data.model.ApiResponse
import com.example.data.model.Footballer
import com.example.data.model.FootballerPositionEnum

interface FootballerRepository {
    suspend fun getAllFootballers(page: Int = 1): ApiResponse
    suspend fun getSingleFootballer(name: String?): ApiResponse
    suspend fun postSingleFootballer(footballer: Footballer?)
    val footballers: Map<Int, List<Footballer>>
    val footballersMockList1: List<Footballer>
        get() = listOf(
            Footballer(
                id = 0,
                name = "Lionel Messi",
                position = FootballerPositionEnum.FORWARD,
                clubName = "Inter Miami",
                imageUrl = "$BASE_URL/messi.jpg"
            ),
            Footballer(
                id = 1,
                name = "Cristiano Ronaldo",
                position = FootballerPositionEnum.FORWARD,
                clubName = "Al Nassr",
                imageUrl = "$BASE_URL/ronaldo.jpg"
            ),
            Footballer(
                id = 2,
                name = "Virgil van Dijk",
                position = FootballerPositionEnum.DEFENDER,
                clubName = "Liverpool",
                imageUrl = "$BASE_URL/vandijk.jpg"
            )
        )

    val footballersMockList2: List<Footballer>
        get() = listOf(
            Footballer(
                id = 3,
                name = "Kevin De Bruyne",
                position = FootballerPositionEnum.MIDFIELDER,
                clubName = "Manchester City",
                imageUrl = "$BASE_URL/debruyne.jpg"
            ),
            Footballer(
                id = 4,
                name = "Manuel Neuer",
                position = FootballerPositionEnum.GOALKEEPER,
                clubName = "Bayern Munich",
                imageUrl = "$BASE_URL/neuer.jpg"
            ),
            Footballer(
                id = 5,
                name = "Kylian Mbappé",
                position = FootballerPositionEnum.FORWARD,
                clubName = "Paris Saint-Germain",
                imageUrl = "$BASE_URL/mbappe.jpg"
            )
        )
    val footballersMockList3: List<Footballer>
        get() = listOf(
            Footballer(
                id = 6,
                name = "Sergio Ramos",
                position = FootballerPositionEnum.DEFENDER,
                clubName = "Paris Saint-Germain",
                imageUrl = "$BASE_URL/ramos.jpg"
            ),
            Footballer(
                id = 7,
                name = "Luka Modrić",
                position = FootballerPositionEnum.MIDFIELDER,
                clubName = "Real Madrid",
                imageUrl = "$BASE_URL/modric.jpg"
            ),
            Footballer(
                id = 8,
                name = "Alisson Becker",
                position = FootballerPositionEnum.GOALKEEPER,
                clubName = "Liverpool",
                imageUrl = "$BASE_URL/alisson.jpg"
            ),
        )

    companion object {
        private const val BASE_URL = "http://localhost:8200"
    }
}