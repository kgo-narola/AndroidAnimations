package com.narola.androidanimations.recyclerviewmotionlayout

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmotionlayout.adapter.AnimationAdapter
import com.example.recyclerviewmotionlayout.model.ItemModel
import com.narola.androidanimations.R
import com.narola.androidanimations.databinding.ActivityMotionLayoutBinding

class MotionLayoutActivity : AppCompatActivity(), AnimationAdapter.onAnimationItemclick {

    lateinit var animationAdapter: AnimationAdapter
    lateinit var binding: ActivityMotionLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_motion_layout)

        updateRecyclerView()

    }

    fun updateRecyclerView() {

        animationAdapter = AnimationAdapter(baseContext, this)
        binding.animationRecycler.layoutManager = LinearLayoutManager(baseContext)
        binding.animationRecycler.adapter = animationAdapter
        animationAdapter.updateItems(addDummyData())

    }

    fun addDummyData(): ArrayList<ItemModel> {

        val arrayList = ArrayList<ItemModel>()

        for (i in 0..5) {
            arrayList.add(ItemModel(i.toString(), false))
        }

        return arrayList

    }

    var selectedPosition = -1
    var lastSelectedPosition = -1
    var lastSelectedMotionLayout: MotionLayout? = null
    var selectedMotionLayout: MotionLayout? = null

    override fun onItemClick(pos: Int, motionLayout: MotionLayout) {
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



    }

}