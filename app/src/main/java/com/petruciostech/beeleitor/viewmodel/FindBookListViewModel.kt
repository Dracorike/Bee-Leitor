package com.petruciostech.beeleitor.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petruciostech.beeleitor.data.RepositoryBooksApi
import com.petruciostech.beeleitor.devtools.TAG_ERROR_FINDBOOKS_VIEWMODEL
import com.petruciostech.beeleitor.framework.apirest.ApiTaskBooks
import com.petruciostech.beeleitor.implementation.BooksDataSourceImplementation
import com.petruciostech.beeleitor.model.DataBooks
import com.petruciostech.beeleitor.usecase.BooksUseCase

class FindBookListViewModel:ViewModel() {
    private val task = ApiTaskBooks()
    private val dataSource = BooksDataSourceImplementation(task)
    private val repository = RepositoryBooksApi(dataSource)
    private val useCase = BooksUseCase(repository)
    private var _booksFinded = MutableLiveData<DataBooks>()
    val booksFinded:LiveData<DataBooks> get() = _booksFinded

    fun findBook(terms:String){
        Thread{
            try {
                _booksFinded.postValue(useCase.invoke(terms))
            }catch (ex:Exception){
                Log.e(TAG_ERROR_FINDBOOKS_VIEWMODEL, "ERROR: $ex")
            }
        }.start()
    }
}