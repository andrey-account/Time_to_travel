package ru.andrey.time_to_travel.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import ru.andrey.time_to_travel.api.ApiWbTest
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    companion object {
        const val BASE_URL = "https://vmeste.wildberries.ru/stream/api/avia-service/v1/suggests/getCheap"
    }

    @Provides
    @Singleton
    fun provideOkHttp(
    ):OkHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideApiService(
        okHttpClient: OkHttpClient
    ): ApiWbTest = ApiWbTest(okHttpClient)
}