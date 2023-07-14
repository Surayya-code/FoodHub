package com.example.foodhub.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.foodhub.R
import com.example.foodhub.databinding.FragmentSignUpBinding
import com.example.foodhub.util.Constants
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class SignUpFragment : Fragment() {
   private var _binding:FragmentSignUpBinding?=null
    private val binding get()=_binding!!
    private val firebaseAuth=FirebaseAuth.getInstance()
    private lateinit var sp: SharedPreferences
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
        setup()
        binding.btnSignUp.setOnClickListener{
            registerUser()
        }

        binding.loginText.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment2_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun setup(){
        sp=requireActivity().getSharedPreferences(Constants.SP_BASE, Context.MODE_PRIVATE)
        checkUser()

    }
    private fun checkUser(){
        val token=sp.getString(Constants.TOKEN,null)
        if(token==null){
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragment2ToHomeFragment())
        }
    }
    private fun registerUser(){
        binding.btnSignUp.setOnClickListener{
            val name=binding.fullNameText.text.toString()
            val username=binding.usernameText.text.toString()
            val email=binding.emailText.text.toString()
            val passw=binding.passwordText.text.toString()

            if( name.isNotEmpty()&& username.isNotEmpty()&& email.isNotEmpty()&& passw.isNotEmpty()){
                if(passw.length>=7){
                    firebaseAuth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener {
                        if(it.isSuccessful){
                             //Snackbar.make(it,"Email bos ola bilmez!", Snackbar.LENGTH_LONG).show()
                            Toast.makeText(context, "Email Success", Toast.LENGTH_LONG).show()
                            findNavController().navigate(R.id.action_signUpFragment2_to_loginFragment)
                        }else{
                            Toast.makeText(context, it.exception?.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }else{
                    //Toast.makeText(requireContext(),"Password is less 7", Toast.LENGTH_SHORT).show()
                    Snackbar.make(it,"Password is less 7", Snackbar.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(requireContext(),"Field doesn't empty!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}