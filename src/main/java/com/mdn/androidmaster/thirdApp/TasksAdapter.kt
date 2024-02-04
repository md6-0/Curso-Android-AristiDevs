package com.mdn.androidmaster.thirdApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdn.androidmaster.R

class TasksAdapter(private var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        //Obtenemos la vista que hará de Item en la lista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.renderItem(tasks[position])
        holder.itemView.setOnClickListener { onTaskSelected(position) }

    }

    override fun getItemCount() = tasks.size

    fun setTasks(newTasks:List<Task>){
        tasks = newTasks
    }

}