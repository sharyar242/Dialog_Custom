package com.example.dialog_custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialog_custom.MainActivity
import com.example.dialog_custom.R
import com.example.dialog_custom.User
import com.example.dialog_custom.ViewHolder

class ListAdapter(private val activity: MainActivity): RecyclerView.Adapter<ViewHolder>() {
    private var models: MutableList<User> = mutableListOf()

    fun setData(data: MutableList<User>) {
        this.models = data
        notifyDataSetChanged()
    }

    fun onItemAdded(position: Int,title:String,description:String){
        models.add(position, User(title,description))
        notifyItemInserted(position)
        notifyItemRangeChanged(position,models.size)

    }

    fun onItemDeleted(position: Int) {
        models.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,models.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.models.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModels(models[position],position,activity)
    }
}