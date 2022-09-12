package com.sample.android.tmdb.di

import com.sample.android.tmdb.domain.Movie
import com.sample.android.tmdb.domain.TVShow
import com.sample.android.tmdb.domain.repo.MovieDetailRepository
import com.sample.android.tmdb.domain.repo.PersonRepository
import com.sample.android.tmdb.domain.repo.TVShowDetailRepository
import com.sample.android.tmdb.domain.repo.BaseFeedRepository
import com.sample.android.tmdb.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindMovieRepository(movieFeedRepository: MovieFeedRepository): BaseFeedRepository<Movie>

    @Singleton
    @Binds
    internal abstract fun bindTVShowRepository(tvShowFeedRepository: TVShowFeedRepository): BaseFeedRepository<TVShow>

    @Singleton
    @Binds
    internal abstract fun bindMovieDetailRepository(movieDetailRepository: MovieDetailRepositoryImpl): MovieDetailRepository

    @Singleton
    @Binds
    internal abstract fun bindTVShowDetailRepository(tvShowDetailRepository: TVShowDetailRepositoryImpl): TVShowDetailRepository

    @Singleton
    @Binds
    internal abstract fun bindPersonRepository(personRepository: PersonRepositoryImpl): PersonRepository
}