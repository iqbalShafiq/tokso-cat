package com.membara.toksocat.view.fragments.knowledgebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.membara.toksocat.databinding.FragmentKnowledgeBaseBinding

class KnowledgeBaseFragment : Fragment() {

    private lateinit var binding: FragmentKnowledgeBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKnowledgeBaseBinding.inflate(
            inflater,
            container,
            false
        );



        return binding.root
    }
}