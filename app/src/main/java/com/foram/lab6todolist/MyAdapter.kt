package com.foram.lab6todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckedTextView
import android.widget.ListView
import com.foram.lab6todolist.databinding.ActivityMainBinding
import com.foram.lab6todolist.databinding.LayoutListItemBinding

class MyAdapter(
    private val mainActivity: MainActivity,
    private val arrToDo: MutableList<String>,
    private val lvItems: ListView,
) :
    BaseAdapter() {

    override fun getCount(): Int {
        return arrToDo.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            LayoutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.ctvItem.text = arrToDo[position]
        return binding.root
    }


}