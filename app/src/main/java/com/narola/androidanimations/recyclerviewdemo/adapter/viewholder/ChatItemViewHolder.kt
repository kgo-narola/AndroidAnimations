package com.harsh.recyclerviewdemo.adapter.viewholder

import android.content.Context
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harsh.recyclerviewdemo.model.ChatItem
import com.narola.androidanimations.databinding.ItemChatBinding

class ChatItemViewHolder(
    var context: Context,
    var itemBinding: ItemChatBinding,
    var itemClick: ((MotionLayout, ChatItem, Int) -> Unit)?
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(chatItem: ChatItem) {

        Glide.with(context).load(chatItem.imgId).into(itemBinding.ivProfile)
        itemBinding.tvName.text =  chatItem.name
        itemBinding.tvMessage.text =  chatItem.message

        itemBinding.ivProfile.setOnClickListener {

            chatItem.isExpanded = !chatItem.isExpanded
            itemClick?.invoke(itemBinding.clMain,chatItem,adapterPosition)
        }
    }
}