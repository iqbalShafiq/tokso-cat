package com.membara.toksocat.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.membara.toksocat.adapter.QuestionAdapter
import com.membara.toksocat.data.Questioner
import com.membara.toksocat.databinding.FragmentQuestionerBinding

class QuestionerFragment : Fragment() {

    private lateinit var binding: FragmentQuestionerBinding
    private lateinit var adapter: QuestionAdapter
    private var questions: MutableList<Questioner> = mutableListOf()

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // view
        with(binding) {
            btnBack.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }
}