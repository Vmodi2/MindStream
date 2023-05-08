package com.example.execdysfunction.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val studySessionDao: StudySessionDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(studySessionDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
