package com.harsh.recyclerviewdemo.model

import androidx.constraintlayout.motion.widget.MotionLayout

data class ChatItem(
    val name: String,
    val message: String,
    val imgId: Int,
    var selectedLayout : MotionLayout ?= null,
    var isExpanded : Boolean = false
)