package com.membara.toksocat.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.membara.toksocat.R
import com.membara.toksocat.data.Disease
import com.membara.toksocat.data.Symptom
import com.membara.toksocat.databinding.FragmentHomeBinding
import com.membara.toksocat.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var symptomList: MutableList<Symptom>
    private lateinit var diseaseList: MutableList<Disease>

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

        // observe live data
        observeLiveData()

        // view
        with(binding) {
            btnBeginTest.setOnClickListener {
                val action = HomeFragmentDirections
                    .navigateToQuestioner(symptomList.toTypedArray())
                Navigation.findNavController(binding.root).navigate(action)
            }

            btnAboutUs.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.navigateToAbout)
            }
        }
    }

    private fun observeLiveData() {
        viewModel.symptoms.observe(viewLifecycleOwner, { symptoms ->
            symptoms?.let {
                symptomList = it as MutableList<Symptom>
            }
        })
    }
}