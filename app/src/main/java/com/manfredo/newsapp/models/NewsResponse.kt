package com.manfredo.newsapp.models

data class NewsResponse(
    val copyright: String,
    val response: Response,
    val status: String
)