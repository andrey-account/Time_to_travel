package ru.andrey.time_to_travel.api

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import ru.andrey.time_to_travel.api.ApiModule
import java.lang.RuntimeException
import javax.inject.Inject

class ApiWbTest @Inject constructor(
    private val client: OkHttpClient,
) {
    @Inject
    fun getListData(startLocationCode: String = "LED"): String {
        val startLocationCodeRequest = "{\"startLocationCode\":\"$startLocationCode\"}"
        val body = startLocationCodeRequest.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        val request = Request.Builder()
            .url(ApiModule.BASE_URL)
            .header("accept", "application/json, text/plain, */*")
            .header("content-type", "application/json")
            .post(body)
            .build()
        try {
            val response = client.newCall(request).execute()
            return response.body?.string() ?: ""
        } catch (e: Exception) {
            throw RuntimeException()
        }
    }
}