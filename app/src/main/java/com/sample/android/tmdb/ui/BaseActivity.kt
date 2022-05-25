package com.sample.android.tmdb.ui

import android.app.ActivityOptions
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.sample.android.tmdb.R
import com.sample.android.tmdb.ui.feed.NavType
import com.sample.android.tmdb.ui.paging.search.movie.SearchMovieActivity
import com.sample.android.tmdb.ui.paging.search.tvshow.SearchTVShowActivity
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    protected abstract val toolbar: Toolbar

    protected abstract val navType: NavType?

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                val searchMenuView: View = toolbar.findViewById(R.id.action_search)
                val options = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    searchMenuView, getString(R.string.transition_search_back)
                ).toBundle()

                val activity = when (navType) {
                    NavType.MOVIES -> SearchMovieActivity::class.java
                    NavType.TV_SERIES -> SearchTVShowActivity::class.java
                    else -> throw RuntimeException("Unknown search navigation type")
                }
                val intent = Intent(this, activity).apply {
                    action = Intent.ACTION_SEARCH
                }
                startActivity(intent, options)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}