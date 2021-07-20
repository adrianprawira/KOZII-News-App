package com.manfredo.newsapp.models

data class Response(
    val docs: MutableList<Docs>,
    val meta: Meta
)