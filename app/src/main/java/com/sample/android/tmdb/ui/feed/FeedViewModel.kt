package com.sample.android.tmdb.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.android.tmdb.domain.FeedWrapper
import com.sample.android.tmdb.domain.TmdbItem
import com.sample.android.tmdb.domain.repo.BaseFeedRepository
import com.sample.android.tmdb.util.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

open class FeedViewModel<T : TmdbItem>(
    private val repository: BaseFeedRepository<T>
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<ViewState<List<FeedWrapper<T>>>>(ViewState.Loading)
    val stateFlow: StateFlow<ViewState<List<FeedWrapper<T>>>>
        get() = _stateFlow.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            repository.result.collect {
                _stateFlow.tryEmit(it)
            }
        }
    }
}