package com.onefootball.ui.news

import android.content.Context
import com.google.gson.Gson
import com.onefootball.model.News
import com.onefootball.model.NewsObject
import java.nio.charset.Charset

class NewsPresenter(view: NewsView) {


    private var view: NewsView = view
    internal fun getNews(context: Context) {

        var jsonString: String?
        var inputStream = context.assets.open("news.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        jsonString = buffer.toString(Charset.defaultCharset())

        val items = parseJsonString(jsonString)

        view.setNewsList(items)
    }

    private fun parseJsonString(jsonString: String): List<News> {
        val newsObject = Gson().fromJson<NewsObject>(jsonString, NewsObject::class.java)
        return newsObject.news
    }

}
