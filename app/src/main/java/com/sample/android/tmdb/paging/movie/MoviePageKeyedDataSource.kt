package com.sample.android.tmdb.paging.movie

import android.content.Context
import com.sample.android.tmdb.data.asMovieDomainModel
import com.sample.android.tmdb.domain.Movie
import com.sample.android.tmdb.network.MovieApi
import com.sample.android.tmdb.paging.BasePageKeyedDataSource
import com.sample.android.tmdb.ui.paging.main.SortType
import io.reactivex.Observable
import java.util.concurrent.Executor

class MoviePageKeyedDataSource(
    private val api: MovieApi,
    private val sortType: SortType,
    retryExecutor: Executor,
    context: Context)
    : BasePageKeyedDataSource<Movie>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<Movie>> = when (sortType) {
        SortType.MOST_POPULAR -> api.popularMovies(page).map { it.items.asMovieDomainModel() }
        SortType.HIGHEST_RATED -> api.topRatedMovies(page).map { it.items.asMovieDomainModel() }
        SortType.UPCOMING -> api.upcomingMovies(page).map { it.items.asMovieDomainModel() }
        SortType.TRENDING -> api.trendingMovies(page).map { it.items.asMovieDomainModel() }
        SortType.NOW_PLAYING -> api.nowPlayingMovies(page).map { it.items.asMovieDomainModel() }
    }
}