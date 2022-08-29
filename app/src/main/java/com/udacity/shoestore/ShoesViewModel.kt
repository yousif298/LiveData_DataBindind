package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel: ViewModel() {
    private var shoesList = MutableLiveData<MutableList<Shoe>>()
    val getShoeList : LiveData<MutableList<Shoe>> get() = shoesList

     var name = MutableLiveData<String>()
     var company = MutableLiveData<String>()
      var description = MutableLiveData<String>()
      var siz =  MutableLiveData<String>()



    init {
        shoesList.value = mutableListOf()
    }
    fun addNewShoe(){
       shoesList.value?.add(Shoe(name.value,siz.value?.toDouble(),company.value,description.value))
    }


}