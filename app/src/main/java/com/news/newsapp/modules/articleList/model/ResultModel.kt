package com.news.newsapp.modules.articleList.model

data class ResultModel(
    var source: MediaModel,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String

)

data class MediaModel(
    var name: String

)

