package com.petruciostech.beeleitor.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") val id:String,
    @SerializedName("etag") val etag:String,
    @SerializedName("volumeInfo") val info:BookInfo
)