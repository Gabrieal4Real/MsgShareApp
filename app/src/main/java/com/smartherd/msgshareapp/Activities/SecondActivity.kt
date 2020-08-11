package com.smartherd.msgshareapp.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.Constants
import com.smartherd.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        //Safe Call                 ?.
        //Safe Call with let        ?.let{}
        //to make code more robust
        bundle?.let {
            Log.d(TAG, "Hello Text Shown")
            val message = bundle.getString(Constants.USER_MSG_KEY)
            for (i in 0..2) {
                println(message + i)
                nameshowtext.text = "Hello $message"
                //hello
            }
        }
    }
}
