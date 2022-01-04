package com.membara.toksocat.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.membara.toksocat.data.Answer
import com.membara.toksocat.databinding.ItemAnswerBinding
import com.membara.toksocat.view.fragments.QuestionerFragment

class AnswerAdapter(
    private val context: Context,
    private val answers: MutableList<Answer>,
    private val fragment: QuestionerFragment
)
    : RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    private lateinit var binding: ItemAnswerBinding
    var focusedPosition = RecyclerView.NO_POSITION

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
                fragment.setEnableNextButtonView()
            } else {
                focusedPosition = RecyclerView.NO_POSITION
                fragment.setDisableNextButtonView()
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return answers.size
    }
}