package com.saja.mytask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionsAdapter(private val transactionsList: List<Transactions>) : RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder>() {

    class TransactionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val paymentTextView: TextView = itemView.findViewById(R.id.transaction_payment)
        val dateTextView: TextView = itemView.findViewById(R.id.transaction_date)
        val amountTextView: TextView = itemView.findViewById(R.id.transaction_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transactions_content, parent, false)
        return TransactionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val transaction = transactionsList[position]
        holder.paymentTextView.text = transaction.payment
        holder.dateTextView.text = transaction.date
        holder.amountTextView.text = transaction.amount
    }

    override fun getItemCount(): Int {
        return transactionsList.size
    }
}
