package com.manfredo.newsapp.models


data class Docs(
    val _id: String,
    val abstract: String,
    val byline: Byline,
    val document_type: String,
    val multimedia: List<Multimedia>,
    val headline: Headline,
    val lead_paragraph: String,
    val news_desk: String,
    val pub_date: String,
    val section_name: String,
    val snippet: String,
    val source: String,
    val subsection_name: String,
    val type_of_material: String,
    val uri: String,
    val web_url: String,
    val word_count: Int
)