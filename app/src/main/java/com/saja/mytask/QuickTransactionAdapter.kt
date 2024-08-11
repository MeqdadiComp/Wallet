package com.saja.mytask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuickTransactionAdapter(private val quickTransactionList: List<QiuckTransaction>) : RecyclerView.Adapter<QuickTransactionAdapter.QuickTransactionViewHolder>() {

    class QuickTransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val quickTransactionImageView: ImageView = itemView.findViewById(R.id.transfer1)
        val quickTransactionNameTv: TextView = itemView.findViewById(R.id.transferName1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickTransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_quick_transfer, parent, false)
        return QuickTransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuickTransactionViewHolder, position: Int) {
        val quickTransfer = quickTransactionList[position]
//        holder.quickTransactionImageView.setImageResource(quickTransfer.quickTransactionImage)
        holder.quickTransactionNameTv.text = quickTransfer.quickTransactionName
    }

    override fun getItemCount(): Int {
        return quickTransactionList.size
    }
}
