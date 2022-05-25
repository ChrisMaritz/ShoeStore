package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoesViewModel
import java.lang.StringBuilder

class ShoeListFragment : Fragment() {
    lateinit var viewModel: ShoesViewModel
    private lateinit var binding: FragmentShoeListBinding

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
         binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        val view = binding.root

        binding.floatingActionButton.setOnClickListener { view1 : View ->
            Navigation.findNavController(view1).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        binding.backToLoginButton.setOnClickListener { view2 : View ->
            Navigation.findNavController(view2).navigate(R.id.action_shoeListFragment_to_loginFragment)
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java);
        viewModel.shoes.observe(viewLifecycleOwner){shoesList->
            val sb = StringBuilder()
            for(shoe in shoesList){
                sb.append(shoe.toString())
            }
            binding.populateThis.text = sb.toString()
        }
    }

}