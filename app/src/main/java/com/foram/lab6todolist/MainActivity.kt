package com.foram.lab6todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.size
import com.foram.lab6todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    private var arrToDo = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listAdapter = MyAdapter(this, arrToDo, binding.lvItems)
        binding.lvItems.adapter = listAdapter

        binding.btnAdd.setOnClickListener {
            if (binding.etAddItem.text.isEmpty()) {
                binding.etAddItem.error = "Please enter item."
            } else {
                arrToDo.add(binding.etAddItem.text.toString())
                binding.etAddItem.text.clear()
                listAdapter.notifyDataSetChanged()
                setVisibility()
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
}