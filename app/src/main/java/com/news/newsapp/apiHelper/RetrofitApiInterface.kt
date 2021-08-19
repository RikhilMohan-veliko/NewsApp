package com.news.newsapp.apiHelper

import com.news.newsapp.modules.articleList.model.ArticleMainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiInterface {

    @GET("top-headlines?country=us")
    fun getArticleList(@Query("apiKey") apiKey: String): Call<ArticleMainModel>


}

