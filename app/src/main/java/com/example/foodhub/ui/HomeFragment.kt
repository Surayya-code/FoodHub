package com.example.foodhub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.foodhub.R
import com.example.foodhub.databinding.FragmentHomeBinding
import com.example.foodhub.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        //
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        toolbar.setNavigationOnClickListener {
//            // Hamburger menü simgesine tıklandığında yapılacak işlemleri burada tanımlayın
//            // Örneğin, yan menüyü açabilir veya belirli bir eylem gerçekleştirebilirsiniz
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}