package com.smartherd.msgshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val message =  bundle!!.getString("user_name")

        for(i in 0..5)
        {
            println(message + i)
            println(message + i)
            println(message + i)
            println(message + i)
            println(message + i)
            nameshowtext.text = "Hello " + message
            //hello
        }
    }
}
