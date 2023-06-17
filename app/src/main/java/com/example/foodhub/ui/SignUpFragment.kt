package com.example.foodhub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodhub.R
import com.example.foodhub.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
   private var _binding:FragmentSignUpBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSignUpBinding.inflate(inflater,container,false)
        //
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment2_to_loginFragment)

        }

        binding.loginText.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment2_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}