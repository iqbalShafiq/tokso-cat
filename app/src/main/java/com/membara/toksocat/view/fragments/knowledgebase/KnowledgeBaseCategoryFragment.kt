package com.membara.toksocat.view.fragments.knowledgebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.membara.toksocat.databinding.FragmentKnowledgeBaseCategoryBinding

class KnowledgeBaseCategoryFragment : Fragment() {

    private lateinit var binding: FragmentKnowledgeBaseCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKnowledgeBaseCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}