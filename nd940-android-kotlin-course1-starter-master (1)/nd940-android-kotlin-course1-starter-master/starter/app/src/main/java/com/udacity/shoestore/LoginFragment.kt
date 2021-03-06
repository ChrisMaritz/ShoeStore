package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

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
        val binding : FragmentLoginBinding  = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val view = binding.root

        binding.loginButton.setOnClickListener { view1 : View ->
            Navigation.findNavController(view1).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        binding.registerButton.setOnClickListener { view1 : View ->
            Navigation.findNavController(view1).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        return view
    }

}