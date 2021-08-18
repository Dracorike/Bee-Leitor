package com.petruciostech.beeleitor.model

import com.google.gson.annotations.SerializedName

data class BookInfo (
    @SerializedName("title") val title:String,
    @SerializedName("authors") val authors:List<String>,
    @SerializedName("description") val description:String,
    @SerializedName("pageCount") val pageCount:Int
)