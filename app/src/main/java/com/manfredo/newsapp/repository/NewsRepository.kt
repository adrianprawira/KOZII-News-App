package com.manfredo.newsapp.repository

import com.manfredo.newsapp.api.RetrofitInstance

class NewsRepository{
    suspend fun getBreakingNews(pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(pageNumber)

    suspend fun searchNews(searhQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searhQuery, pageNumber)
}