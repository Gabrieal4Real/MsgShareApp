package com.smartherd.msgshareapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.msgshareapp.Models.Hobby
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " is your hobby")
                }
            }

            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    val message: String = currentHobby!!.title + " is your hobby"
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Share to: "))
                }
            }
        }

        fun setData(hobby: Hobby?, position: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }
            this.currentHobby = hobby
            this.currentPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}