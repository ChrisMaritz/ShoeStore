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
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: ShoesViewModel

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
        // Inflate the layout for this fragment
        val binding : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)

        val binding2 : FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.cancelButton.setOnClickListener { view1 : View ->
            Navigation.findNavController(view1).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.submitButton.setOnClickListener { view1 : View ->
            getText(binding)
            Navigation.findNavController(view1).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return view
    }

    fun getText(binding: FragmentShoeDetailBinding){
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