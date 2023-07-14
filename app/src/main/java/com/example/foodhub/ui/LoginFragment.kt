package com.example.foodhub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.foodhub.R
import com.example.foodhub.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
  private var _binding:FragmentLoginBinding?=null
    private val binding get()=_binding!!
    private val firebaseAuth=FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignUp.setOnClickListener{
            registerUser()            //findNavController().navigate(R.id.action_loginFragment_to_signUpFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private  fun registerUser(){
        val email=binding.emailText.text.toString().trim()
        val passw=binding.passwordText.text.toString().trim()

        if( email.isNotEmpty()&& passw.isNotEmpty()){
                if(passw.length>=7){
                    firebaseAuth.signInWithEmailAndPassword(email,passw).addOnCompleteListener {
                        if(it.isSuccessful){
                            //Snackbar.make(it,"Email bos ola bilmez!", Snackbar.LENGTH_LONG).show()
                            Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        }else{
                            Toast.makeText(context, it.exception?.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }else{
                    Toast.makeText(requireContext(),"Password is less 7", Toast.LENGTH_SHORT).show()
                    //Snackbar.make(it,"Password is less 7", Snackbar.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(requireContext(),"Fields doesn't empty!", Toast.LENGTH_SHORT).show()
            }
        }
//            if(it.isSuccessful){
//                // Snackbar.make(view,"Email bos ola bilmez!", Snackbar.LENGTH_LONG).show()
//                Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()
//                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//            }else{
//                Toast.makeText(context, it.exception?.message, Toast.LENGTH_LONG).show()
//            }
        }



