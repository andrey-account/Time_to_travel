package ru.andrey.time_to_travel.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.andrey.time_to_travel.repository.AirTravelRepository
import ru.andrey.time_to_travel.repository.AirTravelRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsPostRepository(impl: AirTravelRepositoryImpl): AirTravelRepository
}