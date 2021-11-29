package com.membara.toksocat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.membara.toksocat.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        binding.btnBeginTest.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.navigateToQuestioner)
        }

        binding.btnAboutUs.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.navigateToAbout)
        }

        return binding.root
    }
}