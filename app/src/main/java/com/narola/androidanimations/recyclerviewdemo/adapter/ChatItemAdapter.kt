package com.harsh.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import com.harsh.recyclerviewdemo.adapter.viewholder.ChatItemViewHolder
import com.harsh.recyclerviewdemo.model.ChatItem
import com.narola.androidanimations.databinding.ItemChatBinding

class ChatItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private var chatList: MutableList<ChatItem> = mutableListOf()
    var itemClick: ((MotionLayout,ChatItem,Int) -> Unit)? = null

    fun addItemList(it: List<ChatItem>) {
        chatList = it as MutableList<ChatItem>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatItemViewHolder(
            parent.context,
            itemBinding,
            itemClick
        )
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ChatItemViewHolder) {
            holder.bind(chatList[position])
        }
    }

}