package com.petruciostech.beeleitor.data

import com.petruciostech.beeleitor.model.DataBooks

interface BooksDataSource {
    fun findBooks(terms:String):DataBooks
}