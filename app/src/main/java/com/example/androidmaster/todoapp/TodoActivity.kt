package com.example.androidmaster.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R
import com.example.androidmaster.todoapp.TaskCategory.Business
import com.example.androidmaster.todoapp.TaskCategory.Other
import com.example.androidmaster.todoapp.TaskCategory.Personal
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Personal,
        Business,
        Other
    );

    private val tasks = mutableListOf<Task>(
        Task("Prueba Businnes", Business),
        Task("Prueba Personal", Personal),
        Task("Prueba Other", Other),
    );

    private lateinit var rvCategories: RecyclerView;
    private lateinit var categoryAdapter: CategoriesAdapter;
    private lateinit var rvTasks: RecyclerView;
    private lateinit var taskAdapter: TasksAdapter;

    private lateinit var fabAddTask: FloatingActionButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo);
        initComponents();
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this);
        dialog.setContentView(R.layout.dialog_task);

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask);
        val etTask: EditText = dialog.findViewById(R.id.etTask);
        val rgCategories: RadioGroup = dialog.findViewById((R.id.rgCategories));

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString();

            if (currentTask.isNotEmpty()) {


                val selectedId = rgCategories.checkedRadioButtonId;
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId);
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory));
                updateTasks();
                dialog.hide();
            }
        }

        dialog.show();
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories);
        rvTasks = findViewById(R.id.rvTasks);
        fabAddTask = findViewById(R.id.fabAddTask);
    }

    private fun initUI() {
        categoryAdapter = CategoriesAdapter(categories) { updateCategories(it) };
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvCategories.adapter = categoryAdapter;

        taskAdapter = TasksAdapter(tasks) { onItemSelect(it) }

        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter;
    }

    private fun onItemSelect(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected;
        updateTasks();
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> =
            categories.filter { categorie -> categorie.isSelectd }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.task = newTasks;

        taskAdapter.notifyDataSetChanged()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelectd = !categories[position].isSelectd;
        categoryAdapter.notifyItemChanged(position);
        updateTasks();

    }
}