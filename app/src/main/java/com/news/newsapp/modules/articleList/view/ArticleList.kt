package com.news.newsapp.modules.articleList.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.news.newsapp.R
import com.news.newsapp.baseComponent.BaseFragment
import com.news.newsapp.databinding.FragmentArticleListBinding
import com.news.newsapp.modules.articleList.adapter.ArticleListAdapter
import com.news.newsapp.modules.articleList.model.ResultModel
import com.news.newsapp.modules.articleList.viewModel.ArticleViewModel
import com.news.newsapp.utils.AdapterClickListener
import com.news.newsapp.utils.Utils
import kotlinx.android.synthetic.main.fragment_article_list.*
import kotlinx.android.synthetic.main.fragment_article_list.view.*

class ArticleList<T : ViewDataBinding> : BaseFragment(), AdapterClickListener {
    private var _binding: T? = null
    val binding: T get() = _binding!!

    lateinit var adapterArticle: ArticleListAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var articleViewModel: ArticleViewModel
    lateinit var resultArray: ArrayList<ResultModel>
    private var fragmentArticleListBinding: FragmentArticleListBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articleViewModel =
            ViewModelProvider(this).get(ArticleViewModel::class.java)
        articleViewModel.intAdapter(this)
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false)
        binding.setVariable(BR.viewModel, articleViewModel)
        binding.executePendingBindings()

        articleViewModel.articleData().observe(viewLifecycleOwner, Observer {
            progressBar!!.visibility = View.GONE
            if (it != null) {
                binding.root.txtError.visibility = View.GONE
                binding.root.progressBar!!.visibility = View.GONE
                binding.root.recArticle!!.visibility = View.VISIBLE
                articleViewModel.setAdapterData(it.articles!!)
            } else {
                binding.root.progressBar!!.visibility = View.GONE
                binding.root.txtError.visibility = View.VISIBLE
                binding.root.txtError.text = getString(R.string.somethingWentWrong)
                binding.root.recArticle!!.visibility = View.VISIBLE
            }
        })
        if (Utils.isNetworkConnected(requireActivity())) {
            binding.root.progressBar!!.visibility = View.VISIBLE

            articleViewModel.fetchArticleList()
        } else {
            binding.root.txtError.visibility = View.VISIBLE
            binding.root.txtError.text = getString(R.string.noNetWork)
            binding.root.recArticle!!.visibility = View.GONE
        }


        binding.root.recArticle.apply {

            layoutManager = LinearLayoutManager(requireActivity())
            val decoration =
                DividerItemDecoration(requireContext(), StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }

        val callback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {

                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, // LifecycleOwner
            callback
        )


        return binding.root
    }


    override fun clickItemListener(requestCode: Int, position: ResultModel, view: View) {

    }


}

class ClickHandler {
    fun onTextViewClick(requestCode: Int, position: ResultModel, view: View) {
        when (requestCode) {
            101 -> {

            }
        }
    }
}