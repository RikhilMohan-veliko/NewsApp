package com.news.newsapp.utils

import android.content.Context
import android.net.ConnectivityManager

object Utils {


    fun isNetworkConnected(
        context: Context?
    ): Boolean {
        if (context != null) {
            val connMgr = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connMgr.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        } else {

            return false
        }
    }


}