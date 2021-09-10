package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

public class ShoeViewModel : ViewModel() {

    val  liveList =  MutableLiveData<MutableList<Shoe>>()
    private val mListShoes = ArrayList<Shoe>()

    fun addShoe(newShoe: Shoe) {
        Log.d("WWD", "in addShoe before list is " + liveList.value)
        mListShoes.add(newShoe)
        liveList.value = mListShoes
        Log.d("WWD", "in addShoe the list is now " + liveList.value)
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("WWD", "ShowViewModel onCleared called")
    }






}