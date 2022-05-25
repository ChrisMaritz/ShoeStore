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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: ShoesViewModel
    private lateinit var binding: FragmentShoeListBinding

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