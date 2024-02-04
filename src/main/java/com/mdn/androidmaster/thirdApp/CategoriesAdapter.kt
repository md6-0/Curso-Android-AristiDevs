package com.mdn.androidmaster.thirdApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdn.androidmaster.R

class CategoriesAdapter(private val categories: List<Category>, private val onCategorySelected:(Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        //Obtenemos la vista que hará de Item en la lista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_taskcategory, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.renderItem(categories[position], onCategorySelected)
    }

    override fun getItemCount() = categories.size

}