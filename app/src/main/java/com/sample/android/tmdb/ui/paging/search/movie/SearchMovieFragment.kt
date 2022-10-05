package com.sample.android.tmdb.ui.paging.search.movie

import androidx.lifecycle.ViewModelProvider
import com.sample.android.tmdb.data.Movie
import com.sample.android.tmdb.ui.feed.NavType
import com.sample.android.tmdb.ui.paging.search.BaseSearchFragment
import javax.inject.Inject

class SearchMovieFragment @Inject
constructor() // Required empty public constructor
    : BaseSearchFragment<Movie>() {

    @Inject
    lateinit var factory: SearchMovieViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory).get(SearchMovieViewModel::class.java)

    override val navType: NavType
        get() = NavType.MOVIES
}