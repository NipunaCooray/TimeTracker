package com.example.movietimetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "movie_table")
data class Movie(
    var movieName: String,
    var duration: Int,
    var watchedDate : Date){


        @PrimaryKey
        var movieId: Int = 0

}