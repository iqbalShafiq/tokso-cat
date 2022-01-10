package com.membara.toksocat.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.membara.toksocat.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnKnowledge.setOnClickListener {
                val action = AboutFragmentDirections
                    .navigateToCategoryKnowledgeBase()
                Navigation.findNavController(this.root).navigate(action)
            }

            btnBack.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }
}