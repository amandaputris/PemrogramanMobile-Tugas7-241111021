package com.example.gizigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        findViewById<ImageView>(R.id.btn_back).setOnClickListener {
            finish()
        }

        setupVideoList()
    }

    private fun setupVideoList() {
        val recyclerView = findViewById<RecyclerView>(R.id.video_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        val videos = listOf(
            WorkoutVideo("30-Minute HIIT Cardio Workout with SELF", "SELF • 150 kkal", "30:00", android.R.drawable.ic_menu_gallery),
            WorkoutVideo("Lower Body Power & Core Stability", "GiziGo Fitness • 180 kkal", "12:20", android.R.drawable.ic_menu_gallery)
        )
        
        recyclerView.adapter = WorkoutAdapter(videos)
    }

    data class WorkoutVideo(
        val title: String,
        val meta: String,
        val duration: String,
        val thumbnail: Int
    )

    class WorkoutAdapter(private val items: List<WorkoutVideo>) : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.tv_video_title)
            val meta: TextView = view.findViewById(R.id.tv_video_meta)
            val duration: TextView = view.findViewById(R.id.tv_duration)
            val thumbnail: ImageView = view.findViewById(R.id.iv_thumbnail)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_video, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.title.text = item.title
            holder.meta.text = item.meta
            holder.duration.text = item.duration
            holder.thumbnail.setImageResource(item.thumbnail)
        }

        override fun getItemCount() = items.size
    }
}
