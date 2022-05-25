package com.sample.android.tmdb.ui.feed

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sample.android.tmdb.R
import com.sample.android.tmdb.domain.FeedWrapper
import com.sample.android.tmdb.domain.Movie
import com.sample.android.tmdb.domain.TmdbItem
import com.sample.android.tmdb.ui.common.TmdbTheme
import com.sample.android.tmdb.ui.paging.main.SortType
import com.sample.android.tmdb.ui.paging.main.movie.HighRateMoviesActivity
import com.sample.android.tmdb.ui.paging.main.movie.PopularMoviesActivity
import com.sample.android.tmdb.ui.paging.main.movie.TrendingMoviesActivity
import com.sample.android.tmdb.ui.paging.main.movie.UpcomingMoviesActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.HighRateTVShowActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.LatestTVShowActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.PopularTVShowActivity
import com.sample.android.tmdb.ui.paging.main.tvshow.TrendingTVShowActivity

@Composable
fun <T : TmdbItem> FeedCollectionList(
    navType: NavType,
    collection: List<FeedWrapper<T>>,
    onFeedClick: (TmdbItem) -> Unit
) {
    LazyColumn {

        items(collection) { feedCollection ->
            FeedCollection(
                feedCollection = feedCollection,
                navType = navType,
                onFeedClick = onFeedClick
            )
        }
    }
}

@Composable
private fun <T : TmdbItem> FeedCollection(
    feedCollection: FeedWrapper<T>,
    navType: NavType,
    onFeedClick: (TmdbItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 36.dp)
                .padding(start = 12.dp)
        ) {
            Text(
                text = stringResource(id = feedCollection.sortTypeResourceId),
                maxLines = 1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(
                text = stringResource(R.string.more_item),
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        val activity = when (navType) {
                            NavType.MOVIES -> {
                                when (feedCollection.sortType) {
                                    SortType.TRENDING -> {
                                        TrendingMoviesActivity::class.java
                                    }
                                    SortType.MOST_POPULAR -> {
                                        PopularMoviesActivity::class.java
                                    }
                                    SortType.UPCOMING -> {
                                        UpcomingMoviesActivity::class.java
                                    }
                                    SortType.HIGHEST_RATED -> {
                                        HighRateMoviesActivity::class.java
                                    }
                                }
                            }
                            NavType.TV_SERIES -> {
                                when (feedCollection.sortType) {
                                    SortType.TRENDING -> {
                                        TrendingTVShowActivity::class.java
                                    }
                                    SortType.MOST_POPULAR -> {
                                        PopularTVShowActivity::class.java
                                    }
                                    SortType.UPCOMING -> {
                                        LatestTVShowActivity::class.java
                                    }
                                    SortType.HIGHEST_RATED -> {
                                        HighRateTVShowActivity::class.java
                                    }
                                }
                            }
                        }
                        val intent = Intent(context, activity)
                        context.startActivity(intent)
                    }
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 10.dp)
            )
        }
        Feeds(feedCollection.feeds, onFeedClick)
    }
}

@Composable
private fun <T : TmdbItem> Feeds(
    feeds: List<T>,
    onFeedClick: (TmdbItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = 2.dp, end = 2.dp)
    ) {
        items(feeds) { feed ->
            TmdbItem(feed, onFeedClick)
        }
    }
}

@Composable
private fun <T : TmdbItem> TmdbItem(
    tmdbItem: T,
    onFeedClick: (TmdbItem) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = { onFeedClick(tmdbItem) })
            .padding(6.dp)
    ) {
        Image(
            painter = rememberImagePainter(tmdbItem.posterPath?.let { url ->
                stringResource(R.string.base_poster_path, url)
            }),
            contentDescription = null,
            modifier = Modifier
                .size(width = 120.dp, height = 180.dp)
                .border(.3.dp, Color.White, RectangleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = tmdbItem.name,
            fontSize = TmdbTheme.fontSizes.sp_11,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .size(width = 120.dp, height = 56.dp)
                .padding(top = 6.dp)
        )
    }
}

@Preview("default")
@Composable
fun FeedCardPreview() {
    TmdbTheme {
        val movie = Movie(1, "", null, null, null, "Movie", 1.0)
        TmdbItem(
            tmdbItem = movie,
            onFeedClick = {},
        )
    }
}