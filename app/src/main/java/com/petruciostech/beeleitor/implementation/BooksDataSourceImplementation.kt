package com.petruciostech.beeleitor.implementation

import android.util.Log
import com.petruciostech.beeleitor.data.BooksDataSource
import com.petruciostech.beeleitor.framework.apirest.ApiTaskBooks
import com.petruciostech.beeleitor.model.Book
import com.petruciostech.beeleitor.devtools.TAG_ERROR_BOOKSDATASOURCE
import com.petruciostech.beeleitor.model.DataBooks

class BooksDataSourceImplementation(private val task:ApiTaskBooks):BooksDataSource {
    private lateinit var listBooks:DataBooks
    override fun findBooks(terms: String): DataBooks {
        val response = task.taskApi().findBooks(terms).execute()
        if(response.isSuccessful){
            response.body()?.let { listBooks = it }
        }else{
            Log.e(TAG_ERROR_BOOKSDATASOURCE, "Houve um erro: ${response.errorBody().toString()}")
        }

        return listBooks
    }
}