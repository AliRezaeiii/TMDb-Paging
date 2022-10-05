package com.sample.android.tmdb.ui.paging.search.movie

import com.sample.android.tmdb.R
import com.sample.android.tmdb.data.Movie
import com.sample.android.tmdb.ui.paging.search.SearchActivity
import javax.inject.Inject

class SearchMovieActivity: SearchActivity<Movie>() {

    @Inject
    lateinit var searchMovieFragment: SearchMovieFragment

    override val fragment: SearchMovieFragment
        get() = searchMovieFragment

    override val hintId: Int
        get() = R.string.search_hint_movies
}