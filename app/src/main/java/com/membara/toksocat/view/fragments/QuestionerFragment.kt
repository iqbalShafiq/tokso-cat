package com.membara.toksocat.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.membara.toksocat.R
import com.membara.toksocat.adapter.AnswerAdapter
import com.membara.toksocat.data.Answer
import com.membara.toksocat.data.Questioner
import com.membara.toksocat.databinding.FragmentQuestionerBinding

class QuestionerFragment : Fragment() {

    private lateinit var binding: FragmentQuestionerBinding
    private lateinit var adapter: AnswerAdapter
    private var questions: MutableList<Questioner> = mutableListOf()
    private var answers: MutableList<Answer> = mutableListOf()
    private var position = 0
    private val maxQuestion = 7

    @SuppressLint("SetTextI18n")
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
            questions[position].answers,
            this
        )
        binding.rvAnswer.adapter = adapter
        binding.rvAnswer.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        // init nextButton
        setNextView()

        // onclick event
        binding.btnNext.setOnClickListener {
            position++
            if (position <= maxQuestion) {
                // set question view
                setQuestionView()

                // set question's answer view
                adapter.focusedPosition = RecyclerView.NO_POSITION
                adapter = AnswerAdapter(
                    requireContext(),
                    questions[position].answers,
                    this
                )
                binding.rvAnswer.adapter = adapter

                // set next view after clicked
                setNextView()
            } else {
                // goto result
                Navigation.findNavController(binding.root)
                    .navigate(R.id.navigateToResult)
            }
        }

        binding.btnBack.setOnClickListener {
            // check is it first question or not
            if (position != 0) {
                // goto previous question
                position--
                setQuestionView()

                // set next view
                binding.btnNext.text = "Next"
            } else {
                // goto home fragment
                Navigation.findNavController(binding.root)
                    .navigate(R.id.navigateBackToHomeFromQuestioner)
            }
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun setNextView() {
        // set disabled
        setDisableNextButtonView()

        // check is it the last question or not
        if (position == maxQuestion) {
            // change to finish view
            binding.btnNext.text = "Finish"
        }
    }

    fun setEnableNextButtonView() {
        // set enabled/disabled
        binding.btnNext.isEnabled = true
    }

    fun setDisableNextButtonView() {
        // set enabled/disabled
        binding.btnNext.isEnabled = false
    }

    private fun getDummyQuestions() {
        for (i in 0..maxQuestion) {
            questions.add(
                i, Questioner(
                    "What do you think about the liveliness of your cat ${i + 1}?",
                    getDummyAnswers()
                )
            )
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestionView() {
        binding.tvQuestionPage.text = "Question ${position + 1}"
        binding.tvQuestion.text = questions[position].text
    }

    private fun getDummyAnswers(): MutableList<Answer> {
        answers.clear()
        val dummyAnswer = Answer("A. Very Active", 0.2, 0.8, false)
        for (i in 0 until 4) {
            answers.add(i, dummyAnswer)
        }

        return answers
    }
}