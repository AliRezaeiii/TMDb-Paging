package com.sample.android.tmdb.ui.paging.main.movie

import android.app.Application
import com.sample.android.tmdb.domain.model.Movie
import com.sample.android.tmdb.network.MovieApi
import com.sample.android.tmdb.paging.BasePageKeyRepository
import com.sample.android.tmdb.paging.movie.MoviePageKeyRepository
import com.sample.android.tmdb.ui.paging.main.BaseItemViewModel
import com.sample.android.tmdb.ui.paging.main.SortType

class MovieViewModel(
        api: MovieApi,
        sortType: SortType,
        app: Application
) : BaseItemViewModel<Movie>(app = app) {

    override val mainRepoResult: BasePageKeyRepository<Movie> = MoviePageKeyRepository(api = api,
            sortType = sortType,
            retryExecutor = networkIO,
            context = app.applicationContext)
}