package com.yudha.techtest.di

import com.yudha.techtest.data.remote.GenreApi
import com.yudha.techtest.data.repository.GenreRepository
import com.yudha.techtest.data.repository.GenreRepositoryImpl
import com.yudha.techtest.ui.views.genrelist.GenreListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val genreModule = module {
    single<GenreRepository> {
        GenreRepositoryImpl(
            get(),
            get()
        )
    }
    viewModel { GenreListViewModel(get()) }
    factory { provideGenreApi(get()) }
}

fun provideGenreApi(retrofit: Retrofit): GenreApi =
    retrofit.create(GenreApi::class.java)