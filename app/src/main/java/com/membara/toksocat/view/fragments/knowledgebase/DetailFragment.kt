package com.membara.toksocat.view.fragments.knowledgebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.membara.toksocat.databinding.FragmentDetailKnowledgeBaseBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailKnowledgeBaseBinding
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailKnowledgeBaseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            if (args.symptomText.isNotBlank()) etSymptom.setText(args.symptomText)

            btnAnswerYes.setOnClickListener {
                val action = DetailFragmentDirections
                    .navigateToDestinationCategoryFragment(args.symptomText)
                Navigation.findNavController(binding.root).navigate(action)
            }

            btnAnswerNo.setOnClickListener {
                val action = DetailFragmentDirections
                    .navigateToDestinationCategoryFragment(args.symptomText)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }
}