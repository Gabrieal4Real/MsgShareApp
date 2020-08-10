package com.smartherd.msgshareapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.msgshareapp.HobbiesAdapter
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerview1.layoutManager = layoutManager


        val adapter = HobbiesAdapter(
            this,
            Supplier.hobbies
        )
        recyclerview1.adapter = adapter
    }
}