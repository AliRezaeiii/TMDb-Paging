package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.ui.paging.main.SortType.UPCOMING
import javax.inject.Inject

class OnTheAirTVShowFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = UPCOMING
}