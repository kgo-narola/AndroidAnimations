package com.alarmmanager.zpanimation

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alarmmanager.zpanimation.konfetti.models.Shape
import com.alarmmanager.zpanimation.konfetti.models.Size
import com.narola.androidanimations.R
import com.narola.androidanimations.databinding.ActivityKonfettiAnimationBinding


class KonfettiAnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKonfettiAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonfettiAnimationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.animationView.addLottieOnCompositionLoadedListener {
            showAnimation()
        }
    }

    private fun showAnimation() {

        val display = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(display)

        binding.viewWorkoutResultKonfetti.build()
            .addColors(
                ContextCompat.getColor(this, R.color.color_blue),
                ContextCompat.getColor(this, R.color.color_teal),
                ContextCompat.getColor(this, R.color.color_green),
                ContextCompat.getColor(this, R.color.color_yellow),
                ContextCompat.getColor(this, R.color.color_orange),
                ContextCompat.getColor(this, R.color.color_red)
            )
            .setDirection(0.0, 359.0)
//            .setDirection(300.0, 315.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(10000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12, 5f))
            /* .setPosition(
                 0f,
                 0f,
                 binding.viewWorkoutResultKonfetti.height.toFloat() / 2,
                 binding.viewWorkoutResultKonfetti.height.toFloat()
             )
 */
            .setPosition(
                -50f,
                binding.viewWorkoutResultKonfetti.width + 50f,
                -50f,
                -50f
            )
            .streamFor(100, 5000L)
    }
}