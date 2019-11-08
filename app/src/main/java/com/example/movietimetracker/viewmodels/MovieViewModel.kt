package com.example.movietimetracker.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.movietimetracker.db.DataRepository
import com.example.movietimetracker.db.MovieDatabase
import com.example.movietimetracker.model.Movie
import kotlinx.coroutines.launch

// Class extends AndroidViewModel and requires application as a parameter.
class MovieViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: DataRepository
    // LiveData gives us updated words when they change.
    val allMovies: LiveData<List<Movie>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val movieDao = MovieDatabase.getDatabase(application).movieDao()
        repository = DataRepository(movieDao)
        allMovies = repository.allMovies
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(movie: Movie) = viewModelScope.launch {
        repository.insert(movie)
    }
}