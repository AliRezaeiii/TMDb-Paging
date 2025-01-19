package com.sample.android.tmdb.data.paging.search.tvshow

import android.content.Context
import com.sample.android.tmdb.data.network.TVShowService
import com.sample.android.tmdb.data.response.asTVShowDomainModel
import com.sample.android.tmdb.domain.model.TVShow
import com.sample.android.tmdb.domain.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class SearchTVShowPageKeyedDataSource(
    private val api: TVShowService,
    private val query: String,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyedDataSource<TVShow>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<TVShow>> =
        api.searchItems(page, query).map { it.items.asTVShowDomainModel() }
}