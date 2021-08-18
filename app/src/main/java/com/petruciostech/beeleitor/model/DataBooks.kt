package com.petruciostech.beeleitor.model

import com.google.gson.annotations.SerializedName

data class DataBooks(
    @SerializedName("items") val items:List<Book>
)