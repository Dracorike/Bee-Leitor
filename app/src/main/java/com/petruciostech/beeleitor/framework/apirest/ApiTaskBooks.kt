package com.petruciostech.beeleitor.framework.apirest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiTaskBooks {
    //https://www.googleapis.com/books/v1/volumes?q={search terms}
    companion object{
        const val BASE_URL = "https://www.googleapis.com/"
    }

    private fun provideApi(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun taskApi():BooksApi = provideApi().create(BooksApi::class.java)
}