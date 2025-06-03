package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.repository.NewsRepository


class GetArticle(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(url: String) = newsRepository.getArticle(url)
}