package com.mzcn.tmdbmoviesapp.data.network

import android.util.Log
import com.mzcn.tmdbmoviesapp.secret.TmdbApiKeys
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HeaderValue
import io.ktor.http.HttpHeaders
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class TmdbHttpClient @Inject constructor() {

    fun getHttpClient() = HttpClient(Android) {

        install(ContentNegotiation) {
            json(json = Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 10_000
            connectTimeoutMillis = 10_000
            socketTimeoutMillis = 10_000
        }

        install(ResponseObserver) {
            onResponse {
                Log.i("http_response :", "${it.status.value}")
            }
        }
    }
}