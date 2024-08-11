package com.saja.mytask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saja.mytask.databinding.ItemPopupBinding

class PopupAdapter(private val items: List<String>) :
    RecyclerView.Adapter<PopupAdapter.PopupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopupViewHolder {
        val binding = ItemPopupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopupViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class PopupViewHolder(private val binding: ItemPopupBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.textViewItem.text = item
        }
    }
}
