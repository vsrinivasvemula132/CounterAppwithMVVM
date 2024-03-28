package com.example.vehicleinfo1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vehicleinfo1.model.Counter

class CounterViewModel:ViewModel() {
    private val _counter = MutableLiveData<Counter>()
    val counter: LiveData<Counter> get() = _counter

    init {
        _counter.value = Counter()
    }
    fun incrementCounter() {
        _counter.value?.count = _counter.value?.count?.plus(1) ?: 0
        _counter.postValue(_counter.value)
    }

    fun decrementCounter() {
        _counter.value?.count = _counter.value?.count?.minus(1) ?: 0
        _counter.postValue(_counter.value)
    }
}

