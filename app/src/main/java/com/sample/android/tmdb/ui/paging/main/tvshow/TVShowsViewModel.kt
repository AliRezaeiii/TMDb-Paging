package com.sample.android.tmdb.ui.paging.main.tvshow

import android.app.Application
import com.sample.android.tmdb.domain.model.TVShow
import com.sample.android.tmdb.data.network.TVShowService
import com.sample.android.tmdb.data.paging.BasePageKeyRepository
import com.sample.android.tmdb.data.paging.tvshow.TVShowsPageKeyRepository
import com.sample.android.tmdb.ui.paging.main.BaseItemViewModel
import com.sample.android.tmdb.domain.model.SortType

class TVShowsViewModel(
    api: TVShowService,
    sortType: SortType,
    app: Application
) : BaseItemViewModel<TVShow>(app = app) {

    override val mainRepoResult: BasePageKeyRepository<TVShow> = TVShowsPageKeyRepository(api = api,
            sortType = sortType,
            retryExecutor = networkIO,
            context = app.applicationContext)
}