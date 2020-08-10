package com.smartherd.msgshareapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
                Toast.makeText(this, "Please Enter Message 1", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Welcome " + message, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user_name", message)
                startActivity(intent)
            }
        }

        sharetootherapp.setOnClickListener {
            Log.d("", "Share Button Clicked!")
            val message: String = edittextnextactivity.text.toString()

            if (message.equals("")) {
                Toast.makeText(this, "Please Enter Message 2", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }

        recyclerviewbutton.setOnClickListener {

            val message: String = edittextnextactivity.text.toString()
            if (message.equals("")) {
                Toast.makeText(this, "Please Enter Message 3", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HobbiesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}