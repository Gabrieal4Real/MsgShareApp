package com.smartherd.msgshareapp.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showtoastbutton.setOnClickListener {
            //Code
            Log.d("", "Toast Button Clicked!")
            showToast("Toast Button Clicked!")
        }

        nextactivitybutton.setOnClickListener {
            Log.d("", "Next Activity Button Clicked")

            val message: String = edittextnextactivity.text.toString()

            if (message.equals("")) {
                showToast("Please Enter Message 1")
            } else {
                showToast("Welcome " + message)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user_name", message)
                startActivity(intent)
            }
        }

        sharetootherapp.setOnClickListener {
            Log.d("", "Share Button Clicked!")
            val message: String = edittextnextactivity.text.toString()

            if (message.equals("")) {
                showToast("Please Enter Message 2")
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
                showToast("Please Enter Message 3")
            } else {
                val intent = Intent(this, HobbiesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}