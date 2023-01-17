package com.yudha.techtest.views

import android.content.Context
import android.location.GnssNavigationMessage
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudha.techtest.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import org.jetbrains.anko.toast
abstract class BaseViewModel : ViewModel() {

    val isLoadMore = MutableLiveData(false)

    val isLoading by lazy { MutableLiveData(false) }
    val errorMessage by lazy { SingleLiveEvent<String>() }
    val noInternetConnectionEvent by lazy { SingleLiveEvent<Unit>() }
    val connectTimeoutEvent by lazy { SingleLiveEvent<Unit>() }

    open suspend fun onError(throwable: Throwable) {
        withContext(Dispatchers.Main) {
            when (throwable) {
                is UnknownHostException -> {


                }
                is ConnectException -> {

                }
                is SocketTimeoutException -> {

                }
            }
            hideLoading()
        }
    }

    open fun showError(e: Throwable) {
        errorMessage.postValue(e.message)
    }

    fun showLoading() {
        isLoading.postValue(true)
    }

    fun hideLoading() {
        isLoading.postValue(false)
    }
}