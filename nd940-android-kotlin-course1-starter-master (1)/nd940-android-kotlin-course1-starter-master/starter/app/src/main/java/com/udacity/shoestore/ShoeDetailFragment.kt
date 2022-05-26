package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

class ShoeDetailFragment : Fragment() {

    lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        val view = binding.root

        binding.cancelButton.setOnClickListener { view1 : View ->
            Navigation.findNavController(view1).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.submitButton.setOnClickListener { view1: View ->
            Navigation.findNavController(view1)
                .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            viewModel.addShoe()
        }

        return view
    }
    }
