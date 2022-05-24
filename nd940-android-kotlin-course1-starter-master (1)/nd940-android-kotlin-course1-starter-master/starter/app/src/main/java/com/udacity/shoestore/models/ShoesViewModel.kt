package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {

    private val shoeList = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes : LiveData<MutableList<Shoe>>
        get() = _shoes

    fun addShoe(name: String, size: String, company: String, description: String){
        val shoes1 = Shoe(name, size.toDouble(), company, description)
        shoeList.add(shoes1)
        _shoes.value = shoeList

        Log.i( "Shoes2" , shoeList.toString())
    }

}