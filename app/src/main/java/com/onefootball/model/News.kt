package com.onefootball.model

import com.google.gson.annotations.SerializedName

data class News(
    val title: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("resource_name")
    val resourceName: String,
    @SerializedName("resource_url")
    val resourceUrl: String,
    @SerializedName("news_link")
    val newsLink: String
)