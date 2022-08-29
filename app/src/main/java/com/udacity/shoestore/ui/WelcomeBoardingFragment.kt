package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBoardingBinding

class WelcomeBoardingFragment : Fragment() {

    lateinit var binding:FragmentWelcomeBoardingBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentWelcomeBoardingBinding.inflate(inflater, container, false)

        val data=arguments?.getString("names")
       // Toast.makeText(activity, data, Toast.LENGTH_LONG).show()
        // Inflate the layout for this fragment

        binding.textView2.setText("hello dear"+"  "+data)
        binding.skip.setOnClickListener {
            val s=WelcomeBoardingFragmentDirections.
            actionWelcomeBoardingFragmentToInstructionSscreenFragment(
              )
            findNavController().navigate(
                //    R.id.welcomeBoardingFragment,
                s

            )
        }
        return binding.root
       // return inflater.inflate(R.layout.fragment_welcome_boarding, container, false)
    }



}