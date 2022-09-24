package com.sample.android.tmdb.ui.paging.movie

import android.content.Context
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sample.android.tmdb.ui.BaseMainActivity
import com.sample.android.tmdb.ui.paging.main.movie.TrendingMoviesActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestTrendingMovies : BaseMainActivity() {

    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<TrendingMoviesActivity> =
        object : ActivityTestRule<TrendingMoviesActivity>(
            TrendingMoviesActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                return Intent(targetContext, TrendingMoviesActivity::class.java)
            }
        }

    override val title: String
        get() = "Trending Movies"
}