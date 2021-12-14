package com.sample.android.tmdb.ui.feed

import androidx.lifecycle.ViewModelProvider
import com.sample.android.tmdb.domain.TVShow
import javax.inject.Inject

class FeedTVShowFragment @Inject
constructor() // Required empty public constructor
    : FeedFragment<TVShow>() {

    @Inject
    lateinit var factory: FeedTVShowViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory).get(FeedTVShowViewModel::class.java)


    override val navType: NavType
        get() = NavType.TV_SERIES
}