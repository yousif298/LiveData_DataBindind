package com.udacity.shoestore.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoesViewModel
import com.udacity.shoestore.databinding.FragmentShoeListingScreenBinding
import com.udacity.shoestore.databinding.ShoesRowBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class ShoeListingScreenFragment : Fragment() {
lateinit var binding:FragmentShoeListingScreenBinding
    private val viewModel: ShoesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentShoeListingScreenBinding.inflate(inflater, container, false)
      binding.viewModel = viewModel
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_shoe_listing_screen, container, false)

        viewModel.getShoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                //Inflate the layout using DataBindingUtil
                DataBindingUtil.inflate<ShoesRowBinding>(
                    layoutInflater,
                    R.layout.shoes_row,
                    binding.linearShoesLit,
                    true
                ).apply {
                    this.shoesdata = shoe
                }
            }
        })

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(
                R.id.shoeDetailAddingNewShoeFragment
            )

        }

        setHasOptionsMenu(true)

        return binding.root
    }



   override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       super.onCreateOptionsMenu(menu, inflater)
       inflater.inflate(R.menu.overflowmenu,menu)
   }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {

       if (item.itemId== R.id.logout){
           findNavController().navigate(R.id.loginScreenFragment)
       }

       return super.onOptionsItemSelected(item)


   }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {

                    requireActivity().finish()

                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }
 //  override fun onOptionsItemSelected(item: MenuItem): Boolean {

 //      if (item.itemId== R.id.logout){
 //         findNavController().navigate(R.id.loginScreenFragment)
 //      }

 //      return super.onOptionsItemSelected(item)


 //  }

 //  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
 //      super.onCreateOptionsMenu(menu, inflater)
 //      inflater.inflate(R.menu.overflowmenu,menu)
 //  }


}