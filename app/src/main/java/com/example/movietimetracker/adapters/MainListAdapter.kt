package com.example.movietimetracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movietimetracker.R
import com.example.movietimetracker.model.Movie

class MainListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var movies = emptyList<Movie>() // Cached copy of movies

    inner class MainListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val itemView = inflater.inflate(R.layout.main_recyclerview_item, parent, false)
        return MainListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        val current = movies[position]
        holder.movieTitle.text = current.movieName
    }

    internal fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun getItemCount() = movies.size
}