package com.mdn.androidmaster.thirdApp

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mdn.androidmaster.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTaskName: TextView = view.findViewById(R.id.tvTaskName)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    fun renderItem(task: Task) {
        tvTaskName.text = task.Name

        if (task.isSelected) {
            tvTaskName.paintFlags = tvTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            cbTask.isChecked = true

        } else {
            tvTaskName.paintFlags = tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            cbTask.isChecked = false
        }

        var categoryColor = when (task.category) {
            Category.Business -> R.color.todo_business_category
            Category.Other -> R.color.todo_other_category
            Category.Personal -> R.color.todo_personal_category
        }
        cbTask.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(tvTaskName.context, categoryColor))
    }
}