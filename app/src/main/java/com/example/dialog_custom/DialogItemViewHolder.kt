package com.example.dialog_custom

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dialog_custom.DialogListAdapter
import com.example.dialog_custom.MyModel
import com.example.dialog_custom.R
import kotlinx.android.synthetic.main.item_dialog.view.*

class DialogItemViewHolder(itemView: View, private val  adapter: DialogListAdapter):RecyclerView.ViewHolder(itemView) {

    fun populateModel(model:MyModel, pos:Int){
        itemView.tvNumber.text = model.number.toString()
        if (model.isSelected){
            itemView.ivBg.setImageResource(R.drawable.select_bg)
        }else{
            itemView.ivBg.visibility=View.INVISIBLE
        }
        itemView.setOnClickListener {
            model.isSelected = true
            adapter.selectedItemPosition = pos
        }
    }
}