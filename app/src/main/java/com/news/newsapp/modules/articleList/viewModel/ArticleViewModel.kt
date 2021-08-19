package com.news.newsapp.modules.articleList.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.news.newsapp.apiHelper.RetrofitApiService
import com.news.newsapp.modules.articleList.adapter.ArticleListAdapter
import com.news.newsapp.modules.articleList.model.ArticleMainModel
import com.news.newsapp.modules.articleList.model.ResultModel
import com.news.newsapp.utils.AdapterClickListener
import com.news.newsapp.variabiles.Constants
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel() {

    private val articleData = MutableLiveData<ArticleMainModel?>()

    private val compositeDisposable = CompositeDisposable()
    lateinit var adapterArticle: ArticleListAdapter


    fun intAdapter(adapterClickListener: AdapterClickListener): ArticleListAdapter {
        adapterArticle = ArticleListAdapter(adapterClickListener)
        return adapterArticle
    }

    fun getAdapter(): ArticleListAdapter {
        return adapterArticle
    }

    fun fetchArticleList() {

        val call =
            RetrofitApiService.retrofitApiService?.getArticleList(Constants.KEY)
        call!!.enqueue(object : Callback<ArticleMainModel> {
            override fun onFailure(call: Call<ArticleMainModel>, t: Throwable) {
                articleData.postValue(null)
            }

            override fun onResponse(
                call: Call<ArticleMainModel>, response: Response<ArticleMainModel>
            ) {
                if (response.isSuccessful) {
                    articleData.postValue(response.body())
                } else {
                    articleData.postValue(null)
                }
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun articleData(): MutableLiveData<ArticleMainModel?> {
        return articleData

    }

    fun setAdapterData(data: ArrayList<ResultModel>) {

        adapterArticle.addList(data)
        adapterArticle.notifyDataSetChanged()
    }
}