package com.udacity.shoestore

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

public class ShoeViewModel(): BaseObservable() {

    val  liveList =  MutableLiveData<ArrayList<Shoe>>()
    private var mListShoes = ArrayList<Shoe>()

    var size = ""
    var company = ""
    var description = ""
    fun addShoe(newShoe: Shoe) {
        Log.d("WWD", "name is " + name)
        Log.d("WWD", "size is " + size)
        Log.d("WWD", "company is " + company)
        Log.d("WWD", "description is " + description)
        Log.d("WWD", "in addShoe before list is " + liveList.value)
        mListShoes.add(newShoe)
        liveList.value = mListShoes
        Log.d("WWD", "in addShoe the list is now " + liveList.value)
    }


    /*override fun onCleared() {
        super.onCleared()
        Log.i("WWD", "ShowViewModel onCleared called")
    } */

    @get:Bindable
    val nameTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            // Do nothing.
        }
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            name = s.toString()
        }
        override fun afterTextChanged(s: Editable) {
            // Do nothing.
        }
    }

    @get:Bindable
    var name = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.nameTextWatcher)
        }






}