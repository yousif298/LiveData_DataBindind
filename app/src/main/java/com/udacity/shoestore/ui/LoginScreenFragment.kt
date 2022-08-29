package com.udacity.shoestore.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginScreenBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_login_screen, container, false)


        binding.LoginBtn.setOnClickListener {
            if ( isValed()==true){
                binding.email.text.toString().trim()
                binding.pass.text.toString().trim()
              //  Toast.makeText(this," message", Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, "Test", Toast.LENGTH_LONG).show()

                val s=LoginScreenFragmentDirections.
                actionLoginScreenFragmentToWelcomeBoardingFragment( binding.email.text.toString().trim())
              findNavController().navigate(
              //    R.id.welcomeBoardingFragment,

                s

                  )
            }

        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginScreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun   isValed():Boolean{


        if (  binding.email.text.toString().trim().isEmpty()) {
            binding.email.setError("Enter Email")

            return false
        }

        if  ( binding.pass.text.toString().trim().isEmpty()) {
            binding.pass.setError("Enter Pass")
            return false
        }
        return true
    }

}