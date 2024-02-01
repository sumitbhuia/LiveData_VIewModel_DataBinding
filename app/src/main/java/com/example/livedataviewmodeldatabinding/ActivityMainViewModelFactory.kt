package com.example.livedataviewmodeldatabinding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ActivityMainViewModelFactory(private var startingNum : Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ActivityMainViewModel::class.java)){
            return ActivityMainViewModel(startingNum) as T
        }

        throw IllegalArgumentException("Unknown View Model class ")
    }
}