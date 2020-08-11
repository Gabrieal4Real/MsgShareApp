package com.smartherd.msgshareapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        //Safe Call                 ?.
        //Safe Call with let        ?.let{}
        //to make code more robust
        bundle?.let {
            val message = bundle.getString("user_name")
            for (i in 0..2) {
                println(message + i)
                nameshowtext.text = "Hello " + message
                //hello
            }
        }
    }
}
