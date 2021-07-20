package com.manfredo.newsapp.api

import com.manfredo.newsapp.models.NewsResponse
import com.manfredo.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("articlesearch.json")
    suspend fun getBreakingNews(
        @Query("page")
        pageNumber: Int = 0,
        @Query("api-key")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("articlesearch.json")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 0,
        @Query("api-key")
        apiKey: String = API_KEY
    ): Response<NewsResponse>


}