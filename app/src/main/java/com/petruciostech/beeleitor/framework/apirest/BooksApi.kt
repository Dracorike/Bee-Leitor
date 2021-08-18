package com.petruciostech.beeleitor.framework.apirest

import com.petruciostech.beeleitor.model.DataBooks
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {
    @GET("books/v1/volumes")
    fun findBooks(@Query("q")terms:String):Call<DataBooks>
}