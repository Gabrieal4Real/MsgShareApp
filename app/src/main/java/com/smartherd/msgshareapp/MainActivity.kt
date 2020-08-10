package com.smartherd.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showtoastbutton.setOnClickListener {
            //Code
            Log.d("", "Toast Button Clicked!")

            Toast.makeText(this,"Toast Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        nextactivitybutton.setOnClickListener {
            Log.d("", "Next Activity Button Clicked")

            val message: String = edittextnextactivity.text.toString()

            if(message.equals(""))
            {
                Toast.makeText(this,"Please Enter Name", Toast.LENGTH_SHORT).show()
            }

            else
            {
                Toast.makeText(this,"Welcome " + message, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user_name", message)
                startActivity(intent)
            }
        }
    }
}