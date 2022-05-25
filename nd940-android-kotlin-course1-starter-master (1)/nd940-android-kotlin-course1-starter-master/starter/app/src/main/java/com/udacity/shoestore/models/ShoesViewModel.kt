package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private val shoeList = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes : MutableLiveData<MutableList<Shoe>>
        get() = _shoes

    private val editTextItems = mutableListOf<String>()

    fun addShoe(shoe : Shoe){
        shoeList.add(shoe)
        _shoes.value = shoeList


        Log.i( "Shoes2" , _shoes.toString())
    }

}