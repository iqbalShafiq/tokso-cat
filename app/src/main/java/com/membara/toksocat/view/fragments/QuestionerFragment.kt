package com.membara.toksocat.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.membara.toksocat.databinding.FragmentQuestionerBinding

class QuestionerFragment : Fragment() {

    private lateinit var binding: FragmentQuestionerBinding
    private val args by navArgs<QuestionerFragmentArgs>()
    private lateinit var symptomsText: List<String>
    private var questionPage = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        symptomsText = args.symptoms.map { it.text }

        // view
        setView(questionPage)
    }

    @SuppressLint("SetTextI18n")
    private fun setView(page: Int) {
        val symptom = args.symptoms[page]

        with(binding) {
            tvQuestion.text = "Apakah anda pernah mengalami ${symptom.text}?"

            btnYes.setOnClickListener {
                if (symptomsText.contains(symptom.yesDestination)) {
                    questionPage = symptomsText.indexOf(symptom.yesDestination)
                    setView(questionPage)
                } else {
                    val diseasesText = symptom.yesDestination
                    val action = QuestionerFragmentDirections
                        .navigateToResult(diseasesText!!)
                    Navigation.findNavController(binding.root).navigate(action)
                }
            }

            btnNo.setOnClickListener {
                if (symptomsText.contains(symptom.noDestination)) {
                    questionPage = symptomsText.indexOf(symptom.noDestination)
                    setView(questionPage)
                } else {
                    val diseasesText = symptom.noDestination
                    val action = QuestionerFragmentDirections
                        .navigateToResult(diseasesText!!)
                    Navigation.findNavController(binding.root).navigate(action)
                }
            }
        }
    }
}