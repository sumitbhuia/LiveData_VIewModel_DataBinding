package com.example.livedataviewmodeldatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityMainViewModel(startingNUm:Int):ViewModel() {
        //Making an instance of liveData
        // LiveData is read only , whereas making it mutable will allow editing
        // This variable needs to constantly update
        private var counter = MutableLiveData<Int>()

        // totalSum will be stored in a non editable LiveData instance
        // for clean code this non-mutable instance is made , it will run fine just by observing "total"
        // LiveData requires getters to observe data
        // It's like making totalCount = counter
        val totalCount : LiveData<Int>
            get() = counter



    init{
        // Initially set the total = startingNum (i.e. programmed Input or here 0)
        counter.value = startingNUm
    }

    fun updateCounter(){
        counter.value = counter.value?.plus(1)
    }

}