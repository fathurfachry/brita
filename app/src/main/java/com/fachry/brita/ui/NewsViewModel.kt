package com.example.ujian.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fachry.brita.data.model.NewsResponse
import com.fachry.brita.data.repository.NewsRepository

class NewsViewModel(private val repository: NewsRepository): ViewModel() {

    val merdekaTechNews: LiveData<NewsResponse> = repository.merdekaTechNews
    val merdekaAutoNews: LiveData<NewsResponse> = repository.merdekaAutoNews
    val merdekaWorldNews: LiveData<NewsResponse> = repository.merdekaWorldNews
    val tempoTechNews: LiveData<NewsResponse> = repository.tempoTechNews
    val tempoAutoNews: LiveData<NewsResponse> = repository.tempoAutoNews
    val tempoMetroNews: LiveData<NewsResponse> = repository.tempoMetroNews
    val cnnTechNews: LiveData<NewsResponse> = repository.cnnTechNews
    val cnnEntertainmentNews: LiveData<NewsResponse> = repository.cnnEntertainmentNews
    val cnnEconomyNews: LiveData<NewsResponse> = repository.cnnEconomyNews
    val isLoading: LiveData<Boolean> = repository.isLoading



    fun getMerdekaTechNews() {
        repository.getMerdekaTechNews()
    }
    fun getMerdekaAutoNews() {
        repository.getMerdekaAutoNews()
    }
    fun getMerdekaWorldNews() {
        repository.getMerdekaWorldNews()
    }

    fun getTempoTechNews() {
        repository.getTempoTechNews()
    }
    fun getTempoAutoNews() {
        repository.getTempoAutoNews()
    }
    fun getTempoMetroNews() {
        repository.getTempoMetroNews()
    }

    fun getCNNTechNews() {
        repository.getCNNTechNews()
    }
    fun getCNNEntertainmentNews() {
        repository.getCNNEntertainmentNews()
    }
    fun getCNNEconomyNews() {
        repository.getCNNEconomyNews()
    }

}