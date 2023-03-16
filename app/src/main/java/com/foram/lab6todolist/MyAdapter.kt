package com.foram.lab6todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.foram.lab6todolist.databinding.LayoutListItemBinding

class MyAdapter(
    private val mainActivity: MainActivity,
    private val arrToDo: MutableList<String>,
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

        binding.ctvItem.setOnClickListener {
            if (binding.ctvItem.isChecked) {
                binding.ctvItem.setCheckMarkDrawable(R.drawable.ic_uncheck_mark)
                binding.ctvItem.isChecked = false
            } else {
                binding.ctvItem.setCheckMarkDrawable(R.drawable.ic_check_mark)
                binding.ctvItem.isChecked = true
            }
        }

        binding.ibDelete.setOnClickListener {
            arrToDo.removeAt(position)
            notifyDataSetChanged()
            if (arrToDo.size <= 0) {
                mainActivity.showTextMessage()
            }
        }
        return binding.root
    }

}