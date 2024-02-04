package com.mdn.androidmaster.thirdApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mdn.androidmaster.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.vDivider)
    private val cvTaskCategory: CardView = view.findViewById(R.id.cvTaskCategory)


    fun renderItem(taskCategory: Category, onCategorySelected: (Int) -> Unit) {

        val color =
            if (taskCategory.isSelected) {
                R.color.todo_background_card
            } else {
                R.color.todo_background_disabled
            }
        cvTaskCategory.setCardBackgroundColor(ContextCompat.getColor(vDivider.context, color))

        itemView.setOnClickListener { onCategorySelected(layoutPosition) }


        when (taskCategory) {
            Category.Business -> {
                tvCategoryName.text = tvCategoryName.context.getString(R.string.negocios)
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_business_category)
                )
            }

            Category.Other -> {
                tvCategoryName.text = tvCategoryName.context.getString(R.string.otros)
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_other_category)
                )
            }

            Category.Personal -> {
                tvCategoryName.text = tvCategoryName.context.getString(R.string.personal)
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_personal_category)
                )
            }

        }
    }

}