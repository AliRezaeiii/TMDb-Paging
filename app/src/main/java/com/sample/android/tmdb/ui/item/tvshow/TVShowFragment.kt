package com.sample.android.tmdb.ui.item.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sample.android.tmdb.domain.TVShow
import com.sample.android.tmdb.network.TVShowApi
import com.sample.android.tmdb.ui.TmdbAdapter
import com.sample.android.tmdb.ui.detail.EXTRA_TV_SHOW
import com.sample.android.tmdb.ui.item.BaseItemFragment
import javax.inject.Inject

abstract class TVShowFragment : BaseItemFragment<TVShow>() {

    @Inject
    lateinit var api: TVShowApi

    override val viewModel by lazy { ViewModelProviders.of(this, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return TVShowsViewModel(api, sortType, requireNotNull(activity).application) as T
        }
    })[TVShowsViewModel::class.java] }

    override fun getAdapter(retryCallback: () -> Unit): TmdbAdapter<TVShow> = TVShowAdapter(this, retryCallback)

    override val keyItem = EXTRA_TV_SHOW
}