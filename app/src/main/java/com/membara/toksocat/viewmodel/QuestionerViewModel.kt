package com.membara.toksocat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionerViewModel : ViewModel() {
    private var _position = MutableLiveData<Int>()
    val position: LiveData<Int> get() = _position

    fun back() {
        _position.postValue(_position.value?.minus(1))
    }

    fun next() {
        _position.postValue(_position.value?.plus(1))
    }
}