package com.membara.toksocat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.membara.toksocat.databinding.FragmentQuestionerBinding

class QuestionerFragment : Fragment() {

    private lateinit var binding: FragmentQuestionerBinding
    private lateinit var adapter: AnswerAdapter
    private var questions: MutableList<String> = mutableListOf()
    private var answers: MutableList<Answer> = mutableListOf()
    private var position = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionerBinding.inflate(
            inflater,
            container,
            false
        )

        // init questions list
        getDummyQuestions()
        setQuestionView()

        // init recyclerview & answers list
        adapter = AnswerAdapter(
            requireContext(),
            getDummyAnswers()
        )
        binding.rvAnswer.adapter = adapter
        binding.rvAnswer.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        // onclick event
        binding.btnNext.setOnClickListener {
            position++
            setQuestionView()
        }

        binding.btnBack.setOnClickListener {
            if (position != 0) {
                position--
                setQuestionView()
            } else {
                Navigation.findNavController(binding.root).navigate(R.id.navigateBackToHomeFromQuestioner)
            }
        }

        return binding.root
    }

    private fun getDummyQuestions() {
        questions.add(0, "What do you think about the liveliness of your cat 1?")
        questions.add(1, "What do you think about the liveliness of your cat 2?")
        questions.add(2, "What do you think about the liveliness of your cat 3?")
        questions.add(3, "What do you think about the liveliness of your cat 4?")
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestionView() {
        binding.tvQuestionPage.text = "Question ${position + 1}"
        binding.tvQuestion.text = questions[position]
    }

    private fun getDummyAnswers() : MutableList<Answer> {
        val dummyAnswer = Answer("A. Very Active", 0.2, 0.8, false)
        for (i in 0 until 4) {
            answers.add(i, dummyAnswer)
        }

        return answers
    }
}