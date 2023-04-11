package com.example.bookbuddyv2.ViewModels

import android.telecom.Call
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookbuddyv2.API.CrudApi
import com.example.bookbuddyv2.Model.UserItem
import com.example.bookbuddyv2.Model.UserList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val api: CrudApi = CrudApi()
    //savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(UserList())
    val state: StateFlow<UserList>
        get() = _state

    init {
        viewModelScope.launch {
            val users = api.getUsers()
            _state.value = users
        }
        println(_state.value)
    }
}
