package com.onefootball.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.onefootball.R
import com.onefootball.model.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val newsItems = ArrayList<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.initNewsItem(newsItems[position])
    }

    fun setNewsItems(newListOfNewsItems: List<News>) {
        newsItems.clear()
        newsItems.addAll(newListOfNewsItems)
        notifyDataSetChanged()
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleView: TextView = itemView.findViewById(R.id.news_title)
        var newsView: ImageView = itemView.findViewById(R.id.news_view)
        var resourceImage: ImageView = itemView.findViewById(R.id.resource_icon)
        var resourceName: TextView = itemView.findViewById(R.id.resource_name)


        fun initNewsItem(newsItem: News) {
            titleView.text = newsItem.title
            newsView.load(url = newsItem.imageUrl)
            resourceImage.load(url = newsItem.resourceUrl)
            resourceName.text = newsItem.resourceName
            itemView.setOnClickListener {
                it.context.startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.newsLink))
                )
            }
        }
    }
}
