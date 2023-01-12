package com.yudha.techtest.di



import com.yudha.techtest.data.remote.GenreApi
import com.yudha.techtest.data.remote.MovieApi
import com.yudha.techtest.data.repository.GenreRepository
import com.yudha.techtest.data.repository.GenreRepositoryImpl
import com.yudha.techtest.data.repository.MovieRepository
import com.yudha.techtest.data.repository.MovieRepositoryImpl
import com.yudha.techtest.data.source.MovieListDataSource
import com.yudha.techtest.ui.views.genrelist.GenreListViewModel
import com.yudha.techtest.ui.views.moviedetail.MovieDetailViewModel
import com.yudha.techtest.ui.views.movielist.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
val moduleMovie = module(override=true) {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { MovieListViewModel(get()) }
    factory { provideMovieApi(get()) }
    single { MovieListDataSource(get()) }
}

fun provideMovieDataSource(movieApi: MovieApi) = MovieListDataSource(movieApi)

fun provideMovieApi(retrofit: Retrofit): MovieApi =
    retrofit.create(MovieApi::class.java)