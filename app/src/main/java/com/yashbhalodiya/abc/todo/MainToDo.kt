package com.yashbhalodiya.abc.todo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yashbhalodiya.abc.databinding.MainTodoBinding
import com.yashbhalodiya.abc.databinding.TodoItemBinding

class MainToDo : AppCompatActivity() {
    private lateinit var binding : MainTodoBinding
    private lateinit var listBinding : TodoItemBinding
    private lateinit var dataList : ArrayList<ToDoModel>
    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Initialized binding
        binding = MainTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList = ArrayList()

        //initialise adapter
        toDoAdapter = ToDoAdapter(this, dataList)

        binding.todoAddBtn.setOnClickListener {
            Toast.makeText(this,"aidbf", Toast.LENGTH_SHORT).show()
            var title = binding.todoTitleField.text.toString()
            var desc = binding.todoDescriptionField.text.toString()

            if (title.isEmpty()){
                binding.todoTitleField.error = "Required"
            }else if(desc.isEmpty()){
                binding.todoDescriptionField.error = "Required"
            }else{
                var todo = ToDoModel(title, desc)
                dataList.add(todo)
                toDoAdapter.notifyItemInserted(dataList.size - 1)
                binding.todoTitleField.text.clear()
                binding.todoDescriptionField.text.clear()
            }
        }

        //initialise recycler view
        binding.todoRv.layoutManager = LinearLayoutManager(this)
        binding.todoRv.adapter = toDoAdapter
    }
}