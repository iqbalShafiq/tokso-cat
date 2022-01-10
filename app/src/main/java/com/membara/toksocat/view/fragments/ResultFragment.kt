package com.membara.toksocat.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.membara.toksocat.R
import com.membara.toksocat.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val args by navArgs<ResultFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(
            inflater,
            container,
            false
        )


        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            if (args.disease == "Tidak mengalami Penyakit Toksoplasmosis") {
                tvResult.text = "Anda ${args.disease}"
                ivResult.setImageResource(R.drawable.happy_cat)
                ivStatus.setImageResource(R.drawable.ic_good)
            } else {
                tvResult.text = "Anda terindikasi mengalami ${args.disease}"
                ivResult.setImageResource(R.drawable.sad_cat)
                ivStatus.setImageResource(R.drawable.ic_warning)
            }

            btnBack.setOnClickListener {
                val action = ResultFragmentDirections
                    .navigateBackToHomeFromResult()
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }
}