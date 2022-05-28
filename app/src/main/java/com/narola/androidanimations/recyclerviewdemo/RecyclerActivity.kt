package com.harsh.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.harsh.recyclerviewdemo.adapter.ChatItemAdapter
import com.harsh.recyclerviewdemo.model.ChatItem
import com.narola.androidanimations.R
import com.narola.androidanimations.databinding.ActivityRecyclerviewBinding

class RecyclerActivity : AppCompatActivity() {

    var chatList: ArrayList<ChatItem> = ArrayList()
    private lateinit var chatItemAdapter: ChatItemAdapter
    private lateinit var binding: ActivityRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDummyData()

    }

    private fun getDummyData() {
        chatList.add(
            ChatItem(
                "Tony Stark",
                "Im Iron Man!!!",
                R.drawable.one
            )
        )
        chatList.add(
            ChatItem(
                "Tony Stark",
                "Im Iron Man!!!",
                R.drawable.two
            )
        )
        chatList.add(
            ChatItem(
                "Tony Stark",
                "Im Iron Man!!!",
                R.drawable.three
            )
        )
        chatList.add(
            ChatItem(
                "Tony Stark",
                "Im Iron Man!!!",
                R.drawable.four
            )
        )

        setAdapter()

    }

    var selectedMotionLayout: MotionLayout? = null
    var lastSelectedMotionLayout: MotionLayout? = null
    var selectedPosition = -1
    var lastSelectedPosition = -1


    private fun setAdapter() {
        chatItemAdapter = ChatItemAdapter().apply {
            itemClick = { motionLayout, chatItem, pos ->

                if (selectedPosition == -1 || selectedPosition != pos) {

                    lastSelectedMotionLayout = selectedMotionLayout
                    selectedMotionLayout = motionLayout

                    motionLayout.transitionToEnd()
                    lastSelectedPosition = selectedPosition
                    selectedPosition = pos
                    if (lastSelectedPosition != -1) {
                        lastSelectedMotionLayout?.transitionToStart()
                    }

                } else {

                    motionLayout.transitionToStart()
                    if (lastSelectedPosition != -1) {
                        lastSelectedMotionLayout?.transitionToStart()
                    }
                }
//                if (chatItem.isExpanded) {
//                    motionLayout.transitionToEnd()
//                    if (selectedPosition != pos) {
//                        chatItem.isExpanded = !chatItem.isExpanded
//                        selectedPosition = pos
//                        selectedMotionLayout?.transitionToStart()
//                        selectedMotionLayout = motionLayout
//                    }
//                } else {
//                    motionLayout.transitionToStart()
//                }
            }
        }
        binding.rvChatList.adapter = chatItemAdapter
        chatItemAdapter.addItemList(chatList)
    }
}