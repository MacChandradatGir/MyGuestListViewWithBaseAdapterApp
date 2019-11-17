package com.example.myguestlistviewwithbaseadapterapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myguestlistviewwithbaseadapterapp.R
import com.example.myguestlistviewwithbaseadapterapp.adapter.MyAdapter
import com.example.myguestlistviewwithbaseadapterapp.model.Guest
import kotlinx.android.synthetic.main.activity_second.*
import java.io.BufferedReader
import java.io.InputStreamReader

class SecondActivity : AppCompatActivity() {


    private var guestList = mutableListOf<Guest>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



           readDataFromStorage()

    }

    private fun readDataFromStorage(){

            //creating the inputstream for the file ceated
            val inputFileStream = openFileInput(MainActivity.fileName)

            //creating the input stream reader for the file input stream created
            val inputStreamReader = InputStreamReader(inputFileStream)
            //creating a buffer reader from the input stream reader
            val bufferedReader = BufferedReader(inputStreamReader)

            //resetting the list to 0 values before adding to it
            guestList = mutableListOf()
            var inString : String? =null
            val delimiter: String =":"

            // this is the start of reading from our file using the buffer reader
            // one line at a time and add each line to the array list

            while ({inString = bufferedReader.readLine(); inString}() != null ) {

                val readData = inString?.split(delimiter)

                if(readData?.size ?: 0 > 1){
                    val tempGuest = Guest(
                        readData?.get(0),
                        readData?.get(1),
                        readData?.get(2).toString()
                    )

                    guestList.add(tempGuest)

                }



            }
            bufferedReader.close()

           var myAdapter = MyAdapter(guestList)
           guest_listview.adapter = myAdapter

    }
}
