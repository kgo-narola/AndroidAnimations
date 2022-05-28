package com.harsh.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.narola.androidanimations.R
import com.narola.androidanimations.databinding.ActivityCompactToolbarBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityCompactToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCompactToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureList()
        configureHeader()
    }

    private fun configureList() {
        binding.recyclerView.adapter = MainAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun configureHeader() {
        binding.imageView.setImageDrawable(getDrawable(R.drawable.image_album))
        binding.textView.text = getString(R.string.album_name)
        val albumOfArtist = "${getString(R.string.album_of)} ${getString(
            R.string.album_of
        )}"
        binding.textView2.text = albumOfArtist
    }
}

class MainAdapter : RecyclerView.Adapter<MainAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder =
        SongViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false))

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {

    }

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

