package com.example.foodhub.ui

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.foodhub.R
import com.example.foodhub.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentWelcomeBinding.inflate(inflater,container,false)

        // Arka plan görüntüsünü ayarla
       // binding.root.setBackgroundResource(R.drawable.background_image)
        val background = ContextCompat.getDrawable(requireContext(), R.drawable.background_image)
        val colorFilter = PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
        background?.colorFilter = colorFilter
        binding.root.background = background
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialButtonSignIn.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment2_to_signUpFragment2)
        }
        binding.signinText.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment2_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}

////   val rootView = inflater.inflate(R.layout.fragment_welcome, container, false)
//
//        _binding.setBackgroundResource(R.drawable.backgroundImage)