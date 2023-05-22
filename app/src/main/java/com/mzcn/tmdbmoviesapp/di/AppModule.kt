package com.mzcn.tmdbmoviesapp.di

import com.mzcn.tmdbmoviesapp.repository.MoviesRepository
import com.mzcn.tmdbmoviesapp.repository.MoviesRepositoryImpl
import com.mzcn.tmdbmoviesapp.data.network.TmdbHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun getHttpClient(httpClient: TmdbHttpClient) : HttpClient{
        return httpClient.getHttpClient()
    }

    @Provides
    fun getMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository {
        return impl
    }
}