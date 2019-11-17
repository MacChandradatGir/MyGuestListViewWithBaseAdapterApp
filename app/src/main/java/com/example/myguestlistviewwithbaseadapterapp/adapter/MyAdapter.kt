package com.example.myguestlistviewwithbaseadapterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.myguestlistviewwithbaseadapterapp.R
import com.example.myguestlistviewwithbaseadapterapp.model.Guest


class MyAdapter(private val guestList: List<Guest>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.guest_item_layout, parent, false)

        view.findViewById<TextView>(R.id.room_number_textview).text = guestList[position].room_number.toString()
        view.findViewById<TextView>(R.id.name_textview).text = guestList[position].name
        view.findViewById<TextView>(R.id.price_textview).text = guestList[position].price

        return view

    }

    override fun getItem(position: Int): Guest {
        return guestList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return guestList.size
    }
}