package com.membara.toksocat.view.fragments.knowledgebase

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.membara.toksocat.adapter.KnowledgeBaseAdapter
import com.membara.toksocat.databinding.DialogAddDiseaseBinding
import com.membara.toksocat.databinding.FragmentKnowledgeBaseBinding
import com.membara.toksocat.viewmodel.KnowledgeBaseViewModel

class KnowledgeBaseFragment : Fragment() {

    private lateinit var binding: FragmentKnowledgeBaseBinding
    private val viewModel by activityViewModels<KnowledgeBaseViewModel>()
    private val args by navArgs<KnowledgeBaseFragmentArgs>()
    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentKnowledgeBaseBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get data by category
        category = args.category
        viewModel.getDataByCategory(category)

        // set view
        with(binding) {
            rvList.apply {
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )

                adapter = KnowledgeBaseAdapter(
                    requireContext(),
                    mutableListOf(),
                    category,
                    this@KnowledgeBaseFragment
                )
            }

            btnAdd.setOnClickListener {
                if (category == "symptoms") {
                    val action = KnowledgeBaseFragmentDirections
                        .navigateToDetailKnowledgeBaseFragment("")
                    Navigation.findNavController(this.root).navigate(action)
                } else {
                    showDialogAddDisease()
                }
            }
        }

        // observe data by live data
        observeLiveData()
    }

    fun showDialogAddDisease(disease: String = "") {
        val dialog = Dialog(requireContext())
        val dialogBinding = DialogAddDiseaseBinding.inflate(layoutInflater)

        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(true)
            setContentView(dialogBinding.root)
        }

        with(dialogBinding) {
            if (disease.isNotBlank()) {
                etDisease.setText(disease)
            }

            btnSave.setOnClickListener {
                dialog.dismiss()
            }
        }

        dialog.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
            window?.setLayout(800, 880)
        }
    }

    private fun observeLiveData() {
        viewModel.list.observe(viewLifecycleOwner, { listItem ->
            listItem?.let {
                binding.rvList.adapter = KnowledgeBaseAdapter(
                    requireContext(),
                    listItem as MutableList<String>,
                    category,
                    this
                )
            }
        })
    }
}