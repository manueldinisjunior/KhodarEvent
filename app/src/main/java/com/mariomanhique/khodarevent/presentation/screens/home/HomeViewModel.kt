package com.mariomanhique.khodarevent.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariomanhique.khodarevent.data.repository.KhodarEventsRepoImpl
import com.mariomanhique.khodarevent.model.Community
import com.mariomanhique.khodarevent.model.Event
import com.mariomanhique.khodarevent.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: KhodarEventsRepoImpl,
):ViewModel() {

    private var _data: MutableStateFlow<Result<List<Community>>> = MutableStateFlow(Result.Idle)
    private var _events: MutableStateFlow<Result<List<Event>>> = MutableStateFlow(Result.Idle)
    val  events = _events.asStateFlow()
    val data = _data.asStateFlow()

    init {
        getCommunities()
        getEvents()
    }
    fun getCommunities(){
        viewModelScope.launch {
            _data.value = Result.Loading
            val result = repository.getCommunities()
            if (result.isNotEmpty()){
                _data.value = Result.Success(data = result)
            }else{
                _data.value = Result.Error()
            }

        }
    }

    fun getEvents(){
        viewModelScope.launch {
            _events.value = Result.Loading
            val result = repository.getEvents()
            if (result.isNotEmpty()){
                _events.value = Result.Success(data = result)
            }else{
                _events.value = Result.Error()
            }
        }
    }

}
