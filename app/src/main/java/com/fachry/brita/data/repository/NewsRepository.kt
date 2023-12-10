package com.fachry.brita.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fachry.brita.data.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.fachry.brita.data.network.ApiClient

class NewsRepository {

    private val _merdekaTechNews = MutableLiveData<NewsResponse>()
    val merdekaTechNews: LiveData<NewsResponse> = _merdekaTechNews

    private val _merdekaAutoNews = MutableLiveData<NewsResponse>()
    val merdekaAutoNews: LiveData<NewsResponse> = _merdekaAutoNews

    private val _merdekaWorldNews = MutableLiveData<NewsResponse>()
    val merdekaWorldNews: LiveData<NewsResponse> = _merdekaWorldNews

    private val _tempoTechNews = MutableLiveData<NewsResponse>()
    val tempoTechNews: LiveData<NewsResponse> = _tempoTechNews

    private val _tempoAutoNews = MutableLiveData<NewsResponse>()
    val tempoAutoNews: LiveData<NewsResponse> = _tempoAutoNews

    private val _tempoMetroNews = MutableLiveData<NewsResponse>()
    val tempoMetroNews: LiveData<NewsResponse> = _tempoMetroNews

    private val _cnnTechNews = MutableLiveData<NewsResponse>()
    val cnnTechNews: LiveData<NewsResponse> = _cnnTechNews

    private val _cnnEntertainmentNews = MutableLiveData<NewsResponse>()
    val cnnEntertainmentNews: LiveData<NewsResponse> = _cnnEntertainmentNews

    private val _cnnEconomyNews = MutableLiveData<NewsResponse>()
    val cnnEconomyNews: LiveData<NewsResponse> = _cnnEconomyNews

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMerdekaTechNews(){
        _isLoading.value = true
        ApiClient.getAllService.getMerdekaTechNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        _isLoading.value = false
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _merdekaTechNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }
    fun getMerdekaAutoNews(){
        _isLoading.value = true
        ApiClient.getAllService.getMerdekaAutoNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _merdekaAutoNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }
    fun getMerdekaWorldNews(){
        _isLoading.value = true
        ApiClient.getAllService.getMerdekaWorldNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _merdekaWorldNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }

    fun getTempoTechNews(){
        _isLoading.value = true
        ApiClient.getAllService.getTempoTechNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _tempoTechNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }
    fun getTempoAutoNews(){
        _isLoading.value = true
        ApiClient.getAllService.getTempoAutoNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _tempoAutoNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }
    fun getTempoMetroNews(){
        _isLoading.value = true
        ApiClient.getAllService.getTempoMetroNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _tempoMetroNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }

    fun getCNNTechNews(){
        _isLoading.value = true
        ApiClient.getAllService.getCNNTechNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _cnnTechNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }
    fun getCNNEntertainmentNews(){
        _isLoading.value = true
        ApiClient.getAllService.getCNNEntertainmentNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _cnnEntertainmentNews.postValue(response.body())
                        }
                    } else {
                        Log.e("Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }
    fun getCNNEconomyNews(){
        _isLoading.value = true
        ApiClient.getAllService.getCNNEconomyNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _cnnEconomyNews.postValue(response.body())
                        }
                        } else {
                            Log.e("Repository",
                                "onResponse: Call error with HTTP status code" + response.code()
                            )
                        }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }

            })
    }


}
