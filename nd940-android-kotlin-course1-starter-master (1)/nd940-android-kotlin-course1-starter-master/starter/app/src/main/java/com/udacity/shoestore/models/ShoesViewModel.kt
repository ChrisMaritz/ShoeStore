package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.text.StringBuilder

class ShoesViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()
    private val shoeList = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes : LiveData<MutableList<Shoe>>
        get() = _shoes

    fun addShoe(){

        shoeList.add(
            Shoe(
                shoeName.value.toString(),
                shoeSize.value.toString(),
                shoeCompany.value.toString(),
                shoeDescription.value.toString()))
        _shoes.value = shoeList

    }
}