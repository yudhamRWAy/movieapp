package com.yudha.techtest.ui.views.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.yudha.techtest.views.BaseViewModel
//import com.yudha.techtest.base.views.BaseViewModel
import com.yudha.techtest.data.model.Review
import com.yudha.techtest.data.model.Trailer
import com.yudha.techtest.data.remote.response.DetailMovieResponse

import com.yudha.techtest.data.source.MovieDetailDataSource

import com.yudha.techtest.data.repository.RepoMovie
import kotlinx.coroutines.launch
import timber.log.Timber

class MovieDetailViewModel(
    private val movieRepository: RepoMovie
) : BaseViewModel() {

    val movieDetail = MutableLiveData<DetailMovieResponse>()
    val movieId = MutableLiveData<Int>()
    val trailerKey = MutableLiveData<Trailer>()

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            runCatching {
                showLoading()
                movieRepository.getMovieDetail(movieId)
            }.onSuccess {
                movieDetail.value = it
                hideLoading()
            }.onFailure {
                onError(it)
            }
        }
    }

    fun getTrailerDetail(movieId: Int) {
        viewModelScope.launch {
            runCatching {
                movieRepository.getTrailerDetail(movieId)
            }.onSuccess {
                if (it != null) {
                    trailerKey.value = it.results?.get(0)
                }
            }.onFailure {
                onError(it)
            }
        }
    }


    private val pagedListConfig: PagedList.Config by lazy {
        PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .setPageSize(5)
            .setPrefetchDistance(3)
            .build()
    }

    val reviewList: LiveData<PagedList<Review>> by lazy {
        LivePagedListBuilder(
            object : DataSource.Factory<Int, Review>() {
                override fun create(): DataSource<Int, Review> {
                    return createDataSource()
                }
            }, pagedListConfig
        ).build()
    }

    private var dataSource: MovieDetailDataSource? = null

    fun createDataSource(): MovieDetailDataSource {
        return object : MovieDetailDataSource(viewModel = this@MovieDetailViewModel) {
            override suspend fun loadDataSource(
                loadInitialParams: LoadInitialParams<Int>?,
                loadParams: LoadParams<Int>?,
            ): List<Review> {
                Timber.d("LoadReview lagi")
                return loadReview(loadParams)
            }
        }.apply {
            dataSource = this
        }
    }

    val firstPage = 1

    suspend fun loadReview(
        loadParams: PageKeyedDataSource.LoadParams<Int>?
    ): List<Review> {
        val page = (loadParams?.key ?: firstPage).toString()

        return movieId.value?.let {
            movieRepository.getMovieReviews(page, it).let { reviewResponse ->
                reviewResponse.results?.toList()
            }
        } ?: listOf()
    }
}