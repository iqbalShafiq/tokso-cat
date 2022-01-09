package com.membara.toksocat.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.membara.toksocat.data.Symptom
import com.membara.toksocat.databinding.ItemQuestionBinding
import com.membara.toksocat.view.fragments.QuestionerFragment

class QuestionAdapter(
    private val context: Context,
    private val questions: MutableList<Symptom>,
    private val fragment: QuestionerFragment
) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    private lateinit var binding: ItemQuestionBinding
    var focusedPosition = RecyclerView.NO_POSITION

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemQuestionBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        return ViewHolder(binding.root)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val answer = questions[position]
        holder.setIsRecyclable(false) // fix notifyDataSetChanged() issue

        // set view
        binding.btnAnswer.text = answer.text
        if (focusedPosition == position) {
            binding.btnAnswer.isSelected = true
            binding.btnAnswer.setTextColor(Color.parseColor("#FDEFEF"))
        } else {
            binding.btnAnswer.isSelected = false
            binding.btnAnswer.setTextColor(Color.parseColor("#CDBBA7"))
        }

        // onclick event
        binding.btnAnswer.setOnClickListener {
            // set focused position and refresh items state
            if (focusedPosition != position) {
                focusedPosition = position
            } else {
                focusedPosition = RecyclerView.NO_POSITION
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}