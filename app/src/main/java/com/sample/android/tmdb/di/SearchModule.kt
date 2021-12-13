package com.sample.android.tmdb.di

import com.sample.android.tmdb.ui.feed.EXTRA_NAV_TYPE
import com.sample.android.tmdb.ui.feed.NavType
import com.sample.android.tmdb.ui.paging.search.SearchActivity
import com.sample.android.tmdb.ui.paging.search.movie.SearchMovieFragment
import com.sample.android.tmdb.ui.paging.search.tvshow.SearchTVShowFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchModule {

    @ContributesAndroidInjector
    internal abstract fun searchMovieFragment(): SearchMovieFragment

    @ContributesAndroidInjector
    internal abstract fun searchTVShowFragment(): SearchTVShowFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideNavType(activity: SearchActivity): NavType =
                activity.intent.extras?.getParcelable(EXTRA_NAV_TYPE)!!
    }
}