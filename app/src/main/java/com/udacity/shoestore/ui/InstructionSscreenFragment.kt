package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionSscreenBinding


class InstructionSscreenFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var binding:FragmentInstructionSscreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentInstructionSscreenBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.fragment_instruction_sscreen, container, false)
        binding.Continue.setOnClickListener {
            findNavController().navigate(
               InstructionSscreenFragmentDirections.
               actionInstructionSscreenFragmentToShoeListingScreenFragment()
            )
        }
        return binding.root
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_instruction_sscreen, container, false)
    }

}