package com.news.newsapp.utils

import android.view.View
import com.news.newsapp.modules.articleList.model.ResultModel

interface AdapterClickListener {

    fun clickItemListener(requestCode: Int, position: ResultModel, view: View)

}