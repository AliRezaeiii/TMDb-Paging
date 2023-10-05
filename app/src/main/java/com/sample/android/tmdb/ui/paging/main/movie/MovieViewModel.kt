package com.sample.android.tmdb.ui.paging.main.movie

import android.app.Application
import com.sample.android.tmdb.domain.model.Movie
import com.sample.android.tmdb.data.network.MovieService
import com.sample.android.tmdb.data.paging.BasePageKeyRepository
import com.sample.android.tmdb.data.paging.movie.MoviePageKeyRepository
import com.sample.android.tmdb.ui.paging.main.BaseItemViewModel
import com.sample.android.tmdb.domain.model.SortType

class MovieViewModel(
    api: MovieService,
    sortType: SortType,
    app: Application
) : BaseItemViewModel<Movie>(app = app) {

    override val mainRepoResult: BasePageKeyRepository<Movie> = MoviePageKeyRepository(api = api,
            sortType = sortType,
            retryExecutor = networkIO,
            context = app.applicationContext)
}