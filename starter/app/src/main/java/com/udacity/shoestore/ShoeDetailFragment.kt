package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
var name = ""
var size = ""
var dblSize = 0.0
var company = ""
var description = ""
private lateinit var shoeViewModel: ShoeViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
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
        //return inflater.inflate(R.layout.fragment_shoe_detail, container, false)
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        Log.d("WWD", "in shoe detail onCreateView")
        /*
        binding.createAccountButton.setOnClickListener { v: View ->
            v.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment32())
        }
         */
        binding.cancelBtn.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragment2ToShoeListFragment())
        }

        /* binding.saveBtn.setOnClickListener { v: View ->
            Log.d("WWD", "save button pressed")
            name = binding.shoeNameEt.text.toString()
            size = binding.shoeSizeEt.text.toString()
            dblSize = size.toDouble()
            company = binding.companyNameEt.text.toString()
            description = binding.shoeDescriptionEt.text.toString()
            Log.d("WWD", "name: " + name + "  size: " + dblSize + " company: " + company + " desc: " + description)
            var shoe = Shoe(name, dblSize, company, description)
            //shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
            shoeViewModel = ShoeViewModel()
            shoeViewModel.addShoe(shoe)
            v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragment2ToShoeListFragment())
        } */
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ShoeDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}