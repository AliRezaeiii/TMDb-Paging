package com.sample.android.tmdb.ui.detail

import android.os.Bundle
import android.view.MenuItem
import com.sample.android.tmdb.R
import com.sample.android.tmdb.ui.NavType
import com.sample.android.tmdb.ui.detail.movie.MovieDetailFragment
import com.sample.android.tmdb.ui.detail.tvshow.TVShowDetailFragment
import com.sample.android.tmdb.util.Firebase
import com.sample.android.tmdb.util.Firebase.Companion.ANALYTICS_DETAIL
import com.sample.android.tmdb.util.addFragmentToActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var movieDetailFragment: MovieDetailFragment

    @Inject
    lateinit var tvShowDetailFragment: TVShowDetailFragment

    @Inject
    lateinit var navType: NavType

    @Inject
    lateinit var firebase: Firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        firebase.logEventScreenView(ANALYTICS_DETAIL, navType.name.lowercase())

        if (savedInstanceState == null) {
            val fragment = when (navType) {
                NavType.MOVIES -> movieDetailFragment
                NavType.TV_SERIES -> tvShowDetailFragment
            }
            addFragmentToActivity(fragment, R.id.fragment_container)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

const val EXTRA_TMDB_ITEM = "tmdbItem"
const val EXTRA_NAV_TYPE = "nav_type"