package com.mdn.androidmaster.thirdApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mdn.androidmaster.R
import java.text.FieldPosition

class ThirdAppActivity : AppCompatActivity() {

    //Obtenemos la lista a mostrar
    private val categories = listOf(
        Category.Personal,
        Category.Business,
        Category.Other
    )

    //Declaramos el Recycler View
    private lateinit var rvCategories: RecyclerView

    //Declaramos el Adapter
    private lateinit var categoriesAdapter: CategoriesAdapter


    private var tasks = mutableListOf(
        Task("Tarea de prueba 1", Category.Business),
        Task("Tarea de prueba 2", Category.Other),
        Task("Tarea de prueba 4", Category.Personal)
    )
    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_app)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)

    }

    private fun initUI() {
        //Creamos una instacia de la clase XXXAdapater
        categoriesAdapter = CategoriesAdapter(categories) { onCategorySelected(it) }

        //Indicamos la orientación de la lista
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //Indicamos al RecyclerView cual será el adapter que usará
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TasksAdapter(tasks) { onTaskSelected(it) }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun onCategorySelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        updateCategories(position)
    }

    private fun onTaskSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)

        btnAddTask.setOnClickListener {
            val currentTaskName = etTask.text.toString()

            if (currentTaskName.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val selectedCategory: Category = when (selectedRadioButton.text) {
                    getString(R.string.negocios) -> Category.Business
                    getString(R.string.personal) -> Category.Personal
                    else -> Category.Other
                }
                tasks.add(Task(etTask.text.toString(), selectedCategory, false))
                updateTasks()
                dialog.hide()
            } else {
                Toast.makeText(this, getString(R.string.notEmptyAllowed), Toast.LENGTH_SHORT).show()
            }

        }
        dialog.show()
    }

    private fun updateCategories(position: Int) {
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<Category> = categories.filter { it.isSelected }
        val filteredTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.setTasks(filteredTasks)
        taskAdapter.notifyDataSetChanged()
    }


}

