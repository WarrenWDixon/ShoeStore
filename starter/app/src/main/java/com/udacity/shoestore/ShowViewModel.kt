package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShowViewModel : ViewModel() {

    val listShoes =  MutableLiveData<List<Shoe>>()


    override fun onCleared() {
        super.onCleared()
        Log.i("WWD", "ShowViewModel onCleared called")
    }

}