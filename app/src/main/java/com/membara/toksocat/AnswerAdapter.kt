package com.membara.toksocat

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.membara.toksocat.databinding.ItemAnswerBinding

class AnswerAdapter(
    private val context: Context,
    private val answers: MutableList<Answer>
)
    : RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    private lateinit var binding: ItemAnswerBinding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemAnswerBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        return ViewHolder(binding.root)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val answer = answers[position]
        Log.d("AnswerAdapter", "onBindViewHolder: updated")

        // set view
        binding.btnAnswer.text = answer.text
        if (answer.isSelected) {
            binding.btnAnswer.isSelected = true
            binding.btnAnswer.setTextColor(Color.parseColor("#FDEFEF"))
            Log.d("AnswerAdapter", "onBindViewHolder: $position focused")
        } else {
            binding.btnAnswer.isSelected = false
            binding.btnAnswer.setTextColor(Color.parseColor("#CDBBA7"))
            Log.d("AnswerAdapter", "onBindViewHolder: $position not focused")
        }

        // onclick event
        binding.btnAnswer.setOnClickListener {
            answer.isSelected = !answer.isSelected
            binding.btnAnswer.isSelected = true
            binding.btnAnswer.isEnabled = true
            binding.btnAnswer.setTextColor(Color.parseColor("#FDEFEF"))
            Log.d("AnswerAdapter", "onBindViewHolder: $position focused")
        }
    }

    override fun getItemCount(): Int {
        return answers.size
    }
}