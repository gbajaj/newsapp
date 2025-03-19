package com.loc.newsapp.presentation.search

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.presentation.Dimens.MediumPadding1
import com.loc.newsapp.presentation.common.ArticlesList
import com.loc.newsapp.presentation.common.SearchBar
import com.loc.newsapp.presentation.navgraph.Route
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery, readOnly = false,
            onValueChange = {
                event(SearchEvent.UpdateSearchQuery(it))
            },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(
                articles = articles,
                onClick = {
                    navigate(Route.DetailsScreen.route)
                })
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchScreenPreview() {
    NewsAppTheme {
//        SearchScreen()

    }
}