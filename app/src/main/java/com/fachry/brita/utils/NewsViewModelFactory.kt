package com.fachry.brita.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ujian.ui.NewsViewModel
import com.fachry.brita.data.repository.NewsRepository

class NewsViewModelFactory(private val repository: NewsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)){
            return NewsViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}