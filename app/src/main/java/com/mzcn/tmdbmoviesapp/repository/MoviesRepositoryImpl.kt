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
import java.lang.Exception
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MoviesRepository {
    override suspend fun getPopularMovies(): Resource<PopularMovies> {

        return try {
            Resource.Success(
                httpClient.get{
                    url(HttpRoutes.POPULAR_MOVIES)
                    header(HttpHeaders.Authorization, TmdbApiKeys.AUTH_KEY)
                }.body()
            )

        }catch (e : Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}