package com.sample.android.tmdb.di

import com.sample.android.tmdb.ui.feed.EXTRA_NAV_TYPE
import com.sample.android.tmdb.ui.feed.NavType
import com.sample.android.tmdb.ui.paging.main.movie.HighRateMoviesFragment
import com.sample.android.tmdb.ui.paging.main.movie.PopularMoviesFragment
import com.sample.android.tmdb.ui.paging.main.movie.UpcomingMoviesFragment
import com.sample.android.tmdb.ui.paging.main.tvshow.HighRateTVShowFragment
import com.sample.android.tmdb.ui.paging.main.tvshow.LatestTVShowFragment
import com.sample.android.tmdb.ui.paging.main.tvshow.PopularTVShowFragment
import com.sample.android.tmdb.ui.paging.search.SearchActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    internal abstract fun popularMoviesFragment(): PopularMoviesFragment

    @ContributesAndroidInjector
    internal abstract fun highRateMoviesFragment(): HighRateMoviesFragment

    @ContributesAndroidInjector
    internal abstract fun upcomingMoviesFragment(): UpcomingMoviesFragment

    @ContributesAndroidInjector
    internal abstract fun popularTVShowFragment(): PopularTVShowFragment

    @ContributesAndroidInjector
    internal abstract fun highRateTVShowFragment(): HighRateTVShowFragment

    @ContributesAndroidInjector
    internal abstract fun latestTVShowFragment(): LatestTVShowFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideNavType(activity: SearchActivity): NavType =
            activity.intent.extras?.getParcelable(EXTRA_NAV_TYPE)!!
    }
}