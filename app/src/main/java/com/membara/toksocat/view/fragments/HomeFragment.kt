package com.membara.toksocat.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.membara.toksocat.R
import com.membara.toksocat.databinding.FragmentHomeBinding
import com.membara.toksocat.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // check DB
        viewModel.checkDB()

        // view
        with(binding) {
            btnBeginTest.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.navigateToQuestioner)
            }

            btnAboutUs.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.navigateToAbout)
            }
        }
    }
}