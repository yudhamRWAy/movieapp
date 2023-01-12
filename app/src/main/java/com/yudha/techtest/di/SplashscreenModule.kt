package com.yudha.techtest.di

import com.yudha.techtest.ui.views.splashscreen.SplashscreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleSplashScreen = module {
    viewModel { SplashscreenViewModel() }
}
