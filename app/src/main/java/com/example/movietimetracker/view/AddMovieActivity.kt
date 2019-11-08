package com.example.movietimetracker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.example.movietimetracker.R
import com.example.movietimetracker.model.Movie
import com.example.movietimetracker.viewmodels.MovieViewModel
import java.util.*

private lateinit var mMovieNameEditText: EditText
private lateinit var mDurationEditText: EditText
private lateinit var mCalenderView: CalendarView

private lateinit var mUtilDate: Date



class AddMovieActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        setupViews()
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

    }

    fun addMovie(view: View){
        val movieName  = mMovieNameEditText.text.toString()
        var duration = mDurationEditText.text.toString()

        var durationNumber = Integer.parseInt(duration)

        val movie = Movie(movieName,durationNumber, mUtilDate)

        movieViewModel.insert(movie)

    }

    private fun setupViews() {
        mMovieNameEditText = findViewById(R.id.editText_movie_name)
        mDurationEditText = findViewById(R.id.editText_duration)

        mCalenderView = findViewById(R.id.calendarView)
        mCalenderView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            var cal = Calendar.getInstance()
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            mUtilDate = cal.time
        }

    }

}
