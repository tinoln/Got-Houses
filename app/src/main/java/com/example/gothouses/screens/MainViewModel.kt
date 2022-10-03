package com.example.gothouses.screens

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gothouses.models.House
import com.example.gothouses.retrofit.NetworkResponse
import com.example.gothouses.retrofit.RetroService
import com.example.gothouses.retrofit.RetrofitAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    var houseListResponse:List<House> by mutableStateOf(listOf())
/*
    var houseResponse:House by mutableStateOf(
        House(
            name = "",
            region = "",
            coatOfArms = "",
            words = "",
            titles = null,
            seats = null,
            currentLord = ""
        ))
*/
    var errorMessage: String by mutableStateOf("")

    val retroApiService = RetrofitAPI.getInstance().create(RetroService::class.java)

    fun getHouseList() : List<House>{
        viewModelScope.launch {
            val apiService = retroApiService.getHouses()
            try {
                when(apiService){
                    is  NetworkResponse.Success -> {
                        houseListResponse = apiService.body
                    }
                }
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
        return houseListResponse
    }
}