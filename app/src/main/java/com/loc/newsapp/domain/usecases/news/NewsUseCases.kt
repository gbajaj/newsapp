package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.usecases.news.GetNews
import com.loc.newsapp.presentation.search.SearchEvent

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews
)
