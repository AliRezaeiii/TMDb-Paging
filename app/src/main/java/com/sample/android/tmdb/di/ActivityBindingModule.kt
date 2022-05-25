package com.sample.android.tmdb.di

import com.sample.android.tmdb.di.movie.*
import com.sample.android.tmdb.di.tvshow.*
import com.sample.android.tmdb.ui.detail.movie.DetailMovieActivity
import com.sample.android.tmdb.ui.detail.tvshow.DetailTVShowActivity
import com.sample.android.tmdb.ui.feed.FeedActivity
import com.sample.android.tmdb.ui.paging.main.movie.HighRateMoviesActivity
import com.sample.android.tmdb.ui.paging.main.movie.PopularMoviesActivity
import com.sample.android.tmdb.ui.paging.main.movie.TrendingMoviesActivity
import com.sample.android.tmdb.ui.paging.main.movie.UpcomingMoviesActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.HighRateTVShowActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.LatestTVShowActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.PopularTVShowActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.TrendingTVShowActivity
import com.sample.android.tmdb.ui.paging.search.movie.SearchMovieActivity
import com.sample.android.tmdb.ui.paging.search.tvshow.SearchTVShowActivity
import com.sample.android.tmdb.ui.person.PersonActivity
import com.sample.android.tmdb.ui.start.StartActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [InAppUpdateModule::class])
    internal abstract fun startActivity(): StartActivity

    @ContributesAndroidInjector(modules = [FeedModule::class])
    internal abstract fun feedActivity(): FeedActivity

    @ContributesAndroidInjector(modules = [TrendingMoviesModule::class])
    internal abstract fun trendingMoviesActivity(): TrendingMoviesActivity

    @ContributesAndroidInjector(modules = [PopularMoviesModule::class])
    internal abstract fun popularMoviesActivity(): PopularMoviesActivity

    @ContributesAndroidInjector(modules = [UpcomingMoviesModule::class])
    internal abstract fun upcomingMoviesActivity(): UpcomingMoviesActivity

    @ContributesAndroidInjector(modules = [HighRateMoviesModule::class])
    internal abstract fun highRateMoviesActivity(): HighRateMoviesActivity

    @ContributesAndroidInjector(modules = [TrendingTVShowModule::class])
    internal abstract fun trendingTVShowActivity(): TrendingTVShowActivity

    @ContributesAndroidInjector(modules = [PopularTVShowModule::class])
    internal abstract fun popularTVShowActivity(): PopularTVShowActivity

    @ContributesAndroidInjector(modules = [LatestTVShowModule::class])
    internal abstract fun latestTVShowActivity(): LatestTVShowActivity

    @ContributesAndroidInjector(modules = [HighRateTVShowModule::class])
    internal abstract fun highRateTVShowActivity(): HighRateTVShowActivity

    @ContributesAndroidInjector(modules = [SearchMovieModule::class])
    internal abstract fun searchMovieActivity(): SearchMovieActivity

    @ContributesAndroidInjector(modules = [SearchTVShowModule::class])
    internal abstract fun searchTVShowActivity(): SearchTVShowActivity

    @ContributesAndroidInjector(modules = [DetailMovieModule::class])
    internal abstract fun detailMovieActivity(): DetailMovieActivity

    @ContributesAndroidInjector(modules = [DetailTVShowModule::class])
    internal abstract fun detailTVShowActivity(): DetailTVShowActivity

    @ContributesAndroidInjector(modules = [PersonModule::class])
    internal abstract fun personActivity(): PersonActivity
}