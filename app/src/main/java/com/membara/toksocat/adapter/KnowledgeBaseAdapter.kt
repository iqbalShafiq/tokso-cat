package com.membara.toksocat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.membara.toksocat.databinding.ItemQuestionBinding
import com.membara.toksocat.view.fragments.knowledgebase.KnowledgeBaseFragment
import com.membara.toksocat.view.fragments.knowledgebase.KnowledgeBaseFragmentDirections
import kotlinx.android.synthetic.main.item_question.view.*

class KnowledgeBaseAdapter(
    private val context: Context,
    private val list: MutableList<String>,
    private val category: String,
    private val fragment: KnowledgeBaseFragment
) : RecyclerView.Adapter<KnowledgeBaseAdapter.ViewHolder>() {

    private lateinit var binding: ItemQuestionBinding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemQuestionBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding.root)
    }

    //    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = list[position]

        // set view
        with(holder.itemView) {
            btnAnswer.apply {
                this.text = text
                this.setOnClickListener {
                    if (category == "symptoms") {
                        val action = KnowledgeBaseFragmentDirections
                            .navigateToDetailKnowledgeBaseFragment(text)
                        this.findNavController().navigate(action)
                    } else {
                        fragment.showDialogAddDisease(text)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}