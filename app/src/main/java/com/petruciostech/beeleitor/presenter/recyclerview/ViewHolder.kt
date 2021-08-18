package com.petruciostech.beeleitor.presenter.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.beeleitor.databinding.ItemBookBinding

class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val bind = ItemBookBinding.bind(itemView)
}