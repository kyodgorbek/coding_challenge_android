package com.onefootball.ui.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onefootball.R
import com.onefootball.model.News
import com.onefootball.ui.adapters.NewsAdapter


class MyNewsActivity : AppCompatActivity(), NewsView {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: NewsAdapter

    internal lateinit var mPresenter: NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = NewsPresenter(this)
        recyclerView = findViewById(R.id.newsRecyclerView)
        myAdapter = NewsAdapter()
        with(recyclerView) {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MyNewsActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        mPresenter.getNews(this@MyNewsActivity)
    }

    override fun setNewsList(newsList: List<News>) {
        myAdapter.setNewsItems(newsList)
    }

}
