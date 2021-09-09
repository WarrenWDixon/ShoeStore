package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

public class ShoeViewModel : ViewModel() {

    //val listShoes =  MutableLiveData<List<Shoe>>()
    var myList = mutableListOf<Shoe>()


    override fun onCleared() {
        super.onCleared()
        Log.i("WWD", "ShowViewModel onCleared called")
    }
    //data class Shoe(var name: String, var size: Double, var company: String, var description: String,
    //                val images: List<String> = mutableListOf()) : Parcelable
   public fun addShoe() {
        var shoe1: Shoe = Shoe("MCBoot", 11.0, "HarleyDavidson", "motorcycle boot")
        myList.add(shoe1)
        var shoe2: Shoe = Shoe("MCBoot2", 10.0, "HarleyDavidson", "motorcycle boot size 10")
        myList.add(shoe2)
        var shoe3: Shoe = Shoe("MCBoot3", 9.0, "HarleyDavidson", "motorcycle boot size 9")
        myList.add(shoe3)
        Log.d("WWD", "the list of shoes is " + myList)
    }





}