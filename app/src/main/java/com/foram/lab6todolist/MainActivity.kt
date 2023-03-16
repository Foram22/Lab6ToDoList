package com.foram.lab6todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.size
import com.foram.lab6todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // To Do Array of String variables
    private var arrToDo = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adapter for listview
        val listAdapter = MyAdapter(this, arrToDo)
        binding.lvItems.adapter = listAdapter

        // Add button click event
        binding.btnAdd.setOnClickListener {
            if (binding.etAddItem.text.isEmpty()) {
                binding.etAddItem.error = "Please enter item."
            } else {
                arrToDo.add(binding.etAddItem.text.toString())          // Adding item to array
                binding.etAddItem.text.clear()                          // Clear edit text field
                listAdapter.notifyDataSetChanged()                      // This method will refresh adapter
                binding.tvEmptyListText.visibility = View.GONE
            }
        }

        setVisibility()
    }

    private fun setVisibility() {
        if (binding.lvItems.size > 0) {
            binding.tvEmptyListText.visibility = View.GONE
        } else {
            binding.tvEmptyListText.visibility = View.VISIBLE
        }
    }

    // When delete item from listview and there is no elements left then this method will call
    fun showTextMessage() {
        binding.tvEmptyListText.visibility = View.VISIBLE
    }
}