package com.news.newsapp.modules.articleDetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news.newsapp.R
import com.news.newsapp.baseComponent.BaseFragment


class ArticleDetail : BaseFragment() {
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_article_details, null)




        return rootView
    }


}