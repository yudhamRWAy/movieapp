package com.yudha.techtest.ui.views.genrelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yudha.techtest.views.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class GenreListViewModel(
    private val genreRepository: com.yudha.techtest.data.repository.GenreRepository
) : BaseViewModel() {

    val genreList = MutableLiveData<List<com.yudha.techtest.data.model.Genre>>()

    fun fetchGenre() {
        viewModelScope.launch {
            runCatching {
                showLoading()
                genreRepository.fetchGenreList()
            }.onSuccess {
                it.genres?.let { genres ->
                    withContext(Dispatchers.IO) {
                        Timber.d("GENRESAVEDTODB")
                        genreRepository.saveGenreToDb(genres)
                    }
                    genreList.value = genres
                }
                hideLoading()
            }.onFailure {
                onError(it)
            }
        }
    }

    suspend fun getGenreList(): List<com.yudha.techtest.data.model.Genre>? {
        return genreRepository.getGenreList()
    }

}