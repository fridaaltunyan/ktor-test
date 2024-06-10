package com.example.data.repositories

import com.example.data.model.ApiResponse
import com.example.data.model.Footballer

const val NEXT_PAGE_KEY = "nextPage"
const val PREVIOUS_PAGE_KEY = "prevPage"

class FootballerRepositoryImpl : FootballerRepository {
    override val footballers: Map<Int, List<Footballer>> by lazy {
        mapOf(
            1 to footballersMockList1,
            2 to footballersMockList2,
            3 to footballersMockList3,
        )
    }

    override suspend fun getAllFootballers(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            footballers = footballers[page] ?: emptyList(),
            lastUpdated = System.currentTimeMillis()
        )
    }

    override suspend fun getSingleFootballer(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            footballers = findFootballer(query = name)
        )
    }

    override suspend fun postSingleFootballer(footballer: Footballer?) {
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    private fun findFootballer(query: String?): List<Footballer> {
        val founded = mutableListOf<Footballer>()
        return if (!query.isNullOrEmpty()) {
            footballers.forEach { (_, footballers) ->
                footballers.forEach { hero ->
                    if (hero.name.lowercase().contains(query.lowercase())) {
                        founded.add(hero)
                    }
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}