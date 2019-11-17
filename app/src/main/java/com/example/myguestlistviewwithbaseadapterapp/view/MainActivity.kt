package com.example.myguestlistviewwithbaseadapterapp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myguestlistviewwithbaseadapterapp.R
import com.example.myguestlistviewwithbaseadapterapp.adapter.MyAdapter
import com.example.myguestlistviewwithbaseadapterapp.model.Guest
import com.example.myguestlistviewwithbaseadapterapp.util.Constant
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {



    companion object{
        //Data file name
         val fileName = "MyGuestData.txt"
        var guestList = mutableListOf<Guest>()
    }

   // private val guestList : MutableList<Guest> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_guest_button.setOnClickListener {
           writeToFile()

        }

        display_button.setOnClickListener { _->
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }

    private fun writeToFile() {


        val inputString = "\n${name_edittext.text}: " +
                "${roomnumber_edittext.text}: ${price_edittext.text}"
        val fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND)
        fileOutputStream.write(inputString.toByteArray())
        fileOutputStream.close()

        Toast.makeText(this, "Guest checked in ${roomnumber_edittext.text} ", Toast.LENGTH_SHORT).show()
        clearFields()

    }


    private fun clearFields() {
        name_edittext.text.clear()
        roomnumber_edittext.text.clear()
        price_edittext.text.clear()

    }
}
