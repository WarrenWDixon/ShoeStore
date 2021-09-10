package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.Shoe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class ShoeListFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_shoe_list, container, false)
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_shoe_list, container, false)
        binding.fab.setOnClickListener{ v: View ->
            binding.fab.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment2())
        }
        Log.d("WWD", "in ShoeListFragment onCreateView")
        binding.shoeName.text = "MC Boots"
        binding.shoeSize.text = "11"
        binding.shoeCompany.text = "Harley Davidson"
        binding.shoeDescription.text = "Finest Motorcycle Boots!"
        Log.d("WWD", "just before observer call")
        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        shoeViewModel.liveList.observe(viewLifecycleOwner, Observer {shoeList ->
            Log.d("WWD", "in observer block it: ")
            var len = shoeList.size

            var shoe2 = shoeList[len - 1]
            var n1 = shoe2.name
            var s1 = shoe2.size
            var c1 = shoe2.company
            var d1 = shoe2.description
            binding.shoeName.text = n1
            binding.shoeSize.text = s1.toString()
            binding.shoeCompany.text = c1
            binding.shoeDescription.text = d1
        })
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ShoeListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}