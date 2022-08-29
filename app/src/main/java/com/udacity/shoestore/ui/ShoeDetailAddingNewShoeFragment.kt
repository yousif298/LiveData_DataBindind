package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoesViewModel
import com.udacity.shoestore.databinding.FragmentInstructionSscreenBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailAddingNewShoeBinding
import com.udacity.shoestore.databinding.ShoesRowBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail_adding_new_shoe.*
class ShoeDetailAddingNewShoeFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailAddingNewShoeBinding
    private val viewModel: ShoesViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentShoeDetailAddingNewShoeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.passdata = viewModel


        binding.save.setOnClickListener {

            isValed()
            if(isValed()==true){
                viewModel.addNewShoe()
                findNavController().popBackStack()
            }
      }

        binding.cancel.setOnClickListener { findNavController().popBackStack() }

        return binding.root
    }

    fun   isValed():Boolean{


        if (    shoes_name.text.toString().trim().isEmpty()) {
            shoes_name.setError("Enter shoesName")

            return false
        }

        if  (  shoesdescription.text.toString().trim().isEmpty()) {
            shoesdescription.setError("Enter shoesdescription")
            return false
        }
        if  (   shoesquantity.toString().trim().isEmpty()) {
            shoesquantity.setError("Enter shoesquantity")
            return false
        }
        if  (    sizes.text.toString().trim().isEmpty()) {
           sizes.setError("Enter sizes")
            return false
        }
        return true
    }

}