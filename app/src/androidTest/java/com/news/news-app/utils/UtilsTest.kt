package com.news.`news-app`.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.news.newsapp.utils.Utils

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UtilsTest {

    @Test
    fun whenInputIsValid() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = Utils.isNetworkConnected(context)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInValid() {
        val context = null
        val result = Utils.isNetworkConnected(context)
        assertThat(result).isFalse()
    }

}