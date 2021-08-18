package com.petruciostech.beeleitor.usecase

import com.petruciostech.beeleitor.data.RepositoryBooksApi

class BooksUseCase(private val repository: RepositoryBooksApi) {
    operator fun invoke(terms:String) = repository.findBooks(terms)
}