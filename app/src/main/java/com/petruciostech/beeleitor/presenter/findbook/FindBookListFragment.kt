package com.petruciostech.beeleitor.presenter.findbook

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.petruciostech.beeleitor.R
import com.petruciostech.beeleitor.databinding.FragmentFindBookListBinding
import com.petruciostech.beeleitor.devtools.TAG_INFO_LISTNULL
import com.petruciostech.beeleitor.model.Book
import com.petruciostech.beeleitor.presenter.recyclerview.AdapterRecyclerBooks
import com.petruciostech.beeleitor.viewmodel.FindBookListViewModel

class FindBookListFragment : Fragment() {
    private lateinit var bind:FragmentFindBookListBinding
    private lateinit var viewModel:FindBookListViewModel
    private val bookList = arrayListOf<Book>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentFindBookListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory(activity?.application!!)
            .create(FindBookListViewModel::class.java)
        setHasOptionsMenu(true)
        return bind.root
    }
    private fun findBooks(terms:String){
        viewModel.findBook(terms)
        populateList()
        populateRecyclerView()
    }
    private fun populateList(){
        viewModel.booksFinded.observe(viewLifecycleOwner,{
            if(it != null){
                bookList.addAll(it.items)
            }else{
                Log.i(TAG_INFO_LISTNULL, "A lista de livro está vazia!")
            }
        })
    }
    private fun populateRecyclerView(){
        bind.recyclerFindedbooks.apply{
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            adapter = AdapterRecyclerBooks(bookList)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val searchView:SearchView = menu?.findItem(R.id.search_books).actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                findBooks(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
}