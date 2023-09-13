package ru.andrey.time_to_travel.repository

import kotlinx.coroutines.flow.Flow
import ru.andrey.time_to_travel.dto.Flight

interface AirTravelRepository {

    val data: Flow<List<Flight>>

    suspend fun getAll()

    fun like(flight: Flight)

}