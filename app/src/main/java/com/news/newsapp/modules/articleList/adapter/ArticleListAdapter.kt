package com.news.newsapp.modules.articleList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.databinding.AdapterArticlelistBinding
import com.news.newsapp.modules.articleList.model.ResultModel
import com.news.newsapp.utils.AdapterClickListener
import com.squareup.picasso.Picasso

class ArticleListAdapter(private var adapterClickListener: AdapterClickListener) :
    RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {
    var posts = ArrayList<ResultModel>()
    fun addList(data: ArrayList<ResultModel>) {
        posts.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            AdapterArticlelistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])


    }


    class ViewHolder(val binding: AdapterArticlelistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResultModel) {
            binding.dataValue = data
            binding.executePendingBindings()
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thubmImage: ImageView, url: String) {
            Picasso.get()
                .load(url)
                .into(thubmImage)
        }

    }
}