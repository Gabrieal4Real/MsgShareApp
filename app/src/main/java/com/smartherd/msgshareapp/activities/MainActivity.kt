package com.smartherd.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.Constants
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showtoastbutton.setOnClickListener {
            //Code
            Log.d(TAG, "Toast Button Clicked!")
            showToast(getString(R.string.toast_button_clicked))
        }

        nextactivitybutton.setOnClickListener {
            Log.d(TAG, "Next Activity Button Clicked")
            val message: String = edittextnextactivity.text.toString()
            if (message == "") {
                showToast(getString(R.string.NextActivityButtonClicked), Toast.LENGTH_LONG)
            } else {
                showToast(getString(R.string.welcome) + message)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(Constants.USER_MSG_KEY, message)
                startActivity(intent)
            }
        }

        sharetootherapp.setOnClickListener {
            Log.d(TAG, "Share Button Clicked")
            val message: String = edittextnextactivity.text.toString()
            if (message == "") {
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
            Log.d(TAG, "Recycler Button Clicked")
            val message: String = edittextnextactivity.text.toString()
            if (message == "") {
                showToast("Please Enter Message 3")
            } else {
                val intent = Intent(this, HobbiesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}