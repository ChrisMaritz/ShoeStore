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

        binding.submitButton.setOnClickListener { view1 : View ->
            getText(binding, viewModel)
            Navigation.findNavController(view1).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return view
    }

    fun getText(binding: FragmentShoeDetailBinding, _viewModel: ShoesViewModel){
        val shoeName = binding.shoeNameEdit.text.toString()
        val shoeSize = binding.shoeSizeEdit.text.toString()
        val shoeCompany = binding.shoeCompanyEdit.text.toString()
        val shoeDetail = binding.shoeDetailEdit.text.toString()

        viewModel.addShoe(Shoe(shoeName, shoeSize.toDouble(), shoeCompany, shoeDetail))

        Log.i("shoes", viewModel.shoes.value.toString())

    }

    fun populateShoes(binding: FragmentShoeListBinding, viewModel: ShoesViewModel){

        val value = viewModel.shoes.value

        if (value != null) {
            for(item in value){
                binding.populateThis.text = item.name + "\n"
                binding.populateThis.text = item.size.toString() + "\n"
                binding.populateThis.text = item.company + "\n"
                binding.populateThis.text = item.description + "\n"
            }
        }
    }
}