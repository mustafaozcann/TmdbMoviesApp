package com.mzcn.tmdbmoviesapp.repository

import com.mzcn.tmdbmoviesapp.data.Resource
import com.mzcn.tmdbmoviesapp.data.models.PopularMovies
import com.mzcn.tmdbmoviesapp.data.network.HttpRoutes
import com.mzcn.tmdbmoviesapp.secret.TmdbApiKeys
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart
import java.lang.Exception
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MoviesRepository {
    override suspend fun getPopularMovies(): Flow<Resource<PopularMovies>> {

        return try {
            flowOf<Resource<PopularMovies>>(
                Resource.Success(
                    httpClient.get {
                        url(HttpRoutes.POPULAR_MOVIES)
                        header(HttpHeaders.Authorization, TmdbApiKeys.AUTH_KEY)
                    }.body()
                )
            ).onStart { emit(Resource.Loading) }

        } catch (e: Exception) {
            e.printStackTrace()
            flowOf(Resource.Failure(e))
        }
    }
}