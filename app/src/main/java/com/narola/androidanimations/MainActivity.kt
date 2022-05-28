package com.harsh.recyclerviewdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.alarmmanager.zpanimation.KonfettiAnimationActivity
import com.harsh.recyclerviewdemo.adapter.ChatItemAdapter
import com.harsh.recyclerviewdemo.model.ChatItem
import com.narola.androidanimations.R
import com.narola.androidanimations.databinding.ActivityMainBinding
import com.narola.androidanimations.recyclerviewmotionlayout.MotionLayoutActivity

class MainActivity : AppCompatActivity() {

    var chatList: ArrayList<ChatItem> = ArrayList()
    private lateinit var chatItemAdapter: ChatItemAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val intent = Intent(this@MainActivity,RecyclerActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this@MainActivity, KonfettiAnimationActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this@MainActivity, MotionLayoutActivity::class.java)
            startActivity(intent)
        }

    }

}