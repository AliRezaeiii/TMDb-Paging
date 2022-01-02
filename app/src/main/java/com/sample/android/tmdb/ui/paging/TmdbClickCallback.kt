package com.sample.android.tmdb.ui.paging

import android.os.Parcelable
import android.view.View

interface TmdbClickCallback<T : Parcelable> {
    fun onClick(t: T, poster: View)
}