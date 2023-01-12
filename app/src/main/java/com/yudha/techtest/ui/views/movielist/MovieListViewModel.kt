package com.yudha.techtest.ui.views.movielist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.yudha.techtest.views.BaseViewModel

import com.yudha.techtest.data.model.Movie
import com.yudha.techtest.data.source.MovieListDataSource
import kotlinx.coroutines.flow.Flow

class MovieListViewModel(
    private val movieListDataSource: MovieListDataSource
) : BaseViewModel() {

    var genreId = MutableLiveData<Int>()

    fun getMovieList(): Flow<PagingData<Movie>> {
        movieListDataSource.genreId = genreId
        return Pager(PagingConfig(pageSize = 10), pagingSourceFactory = {movieListDataSource} ).flow.cachedIn(viewModelScope)
    }

}