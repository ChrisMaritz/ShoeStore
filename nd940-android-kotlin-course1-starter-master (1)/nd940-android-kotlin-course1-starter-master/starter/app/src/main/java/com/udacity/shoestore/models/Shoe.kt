package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.lang.StringBuilder

@Parcelize
data class Shoe(
    var name: String, var size: String, var company: String, var description: String,
    val images: List<String> = mutableListOf()) : Parcelable{


    override fun toString(): String {
        val sb = StringBuilder()

            sb.append(name).append("\n")
            sb.append(size).append("\n")
            sb.append(company).append("\n")
            sb.append(description).append("\n\n")


        return sb.toString()
    }
                }