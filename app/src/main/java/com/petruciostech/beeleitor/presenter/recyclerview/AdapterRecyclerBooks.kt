package com.petruciostech.beeleitor.presenter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.beeleitor.R
import com.petruciostech.beeleitor.model.Book
import com.petruciostech.beeleitor.model.BookInfo

class AdapterRecyclerBooks(private val bookList:List<Book>):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.itembookTitle.text = bookList[position].info.title
        holder.bind.itembookDescription.text = bookList[position].info.description
    }

    override fun getItemCount(): Int = bookList.size
}