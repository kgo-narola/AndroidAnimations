package com.example.recyclerviewmotionlayout.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmotionlayout.model.ItemModel
import com.narola.androidanimations.R
import com.narola.androidanimations.databinding.AdapterItemBinding

class AnimationAdapter(val context: Context, val animationItemclick: onAnimationItemclick) : RecyclerView.Adapter<AnimationAdapter.ViewHolder>() {

    var list = ArrayList<ItemModel>()
    var selectedPosition = -1
    var lastSelectedPosition = -1

    inner class ViewHolder(val itemBinding: AdapterItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {

            itemBinding.root.setOnClickListener {
                Log.i("TAG", " selected position : "+selectedPosition)
                Log.i("TAG", " lastSelectedPosition : "+lastSelectedPosition)
                Log.i("TAG", " selected adapterPosition : "+adapterPosition)
                lastSelectedPosition = selectedPosition
                selectedPosition = adapterPosition

                animationItemclick.onItemClick(adapterPosition,itemBinding.textContainer)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(

            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.adapter_item,
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemBinding.text = list[position].itemName



    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newList: ArrayList<ItemModel>) {
        list = newList
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onAnimationItemclick{

        fun onItemClick(position: Int,layoutItem:MotionLayout)

    }
}