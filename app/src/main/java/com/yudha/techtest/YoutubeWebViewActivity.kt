package com.yudha.techtest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.yudha.techtest.databinding.ListMovieFragmentBinding
import com.yudha.techtest.databinding.YoutubeActivityBinding
import com.yudha.techtest.ui.views.moviedetail.MovieDetailViewModel

import org.koin.androidx.viewmodel.ext.android.viewModel


class YoutubeWebViewActivity : AppCompatActivity(R.layout.youtube_activity){
    val viewModel: MovieDetailViewModel by viewModel()
    private lateinit var binding : YoutubeActivityBinding






    //    private val args: MovieDetailFragmentArgs by navArgs() private lateinit var args: Movie


    @RequiresApi(Build.VERSION_CODES.O)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        ListMovieFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        webViewSetup()

        }





    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {

        binding.webView.webViewClient = WebViewClient()
        binding.webView.apply {
            intent = intent
            var uri = intent.getStringExtra("key")
            if (uri != null) {
                loadUrl(uri)
            }

                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true




                }


        }
    }



