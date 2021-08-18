package com.petruciostech.beeleitor.data

import com.petruciostech.beeleitor.model.DataBooks

class RepositoryBooksApi(private val dataSource: BooksDataSource) {
    fun findBooks(terms:String):DataBooks = dataSource.findBooks(terms)
}