package com.yudha.techtest.ui.views.splashscreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yudha.techtest.R
import com.yudha.techtest.views.BaseFragment
import com.yudha.techtest.views.getNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashscreenFragment : BaseFragment<SplashscreenViewModel>() {
    override val viewModel: SplashscreenViewModel by viewModel()

    override fun layoutRes(): Int = R.layout.splashscreenapp

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            delay(1000)
            getNavController()?.navigate(SplashscreenFragmentDirections.toGenreList())
        }
    }
}