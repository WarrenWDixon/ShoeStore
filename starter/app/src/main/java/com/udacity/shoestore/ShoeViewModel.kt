package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

public class ShoeViewModel : ViewModel() {

    //val listShoes =  MutableLiveData<List<Shoe>>()
    var myList = mutableListOf<Shoe>()
    val  liveList =  MutableLiveData<MutableList<Shoe>>()
    private val mListShoes = ArrayList<Shoe>()
    private val mShoesLiveData = MutableLiveData<List<Shoe>>()

    fun addShoe(newShoe: Shoe) {
        Log.d("WWD", "in addShoe before list is " + mShoesLiveData.value)
        mListShoes.add(newShoe)
        mShoesLiveData.value = mListShoes
        Log.d("WWD", "in addShoe the list is now " + mShoesLiveData.value)
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("WWD", "ShowViewModel onCleared called")
    }






}