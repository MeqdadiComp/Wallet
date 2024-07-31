package com.saja.mytask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class IdCardAdapter(private  val idCardList: List<IdCard>) : RecyclerView.Adapter<IdCardAdapter.IdCardViewHolder>() {

    class IdCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  idCardImageView : ConstraintLayout = itemView.findViewById(R.id.idCard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_card , parent , false)
        return IdCardViewHolder(view)

    }


    override fun onBindViewHolder(holder: IdCardViewHolder, position: Int) {
        val idCard = idCardList[position]
        holder.idCardImageView.setBackgroundResource(idCard.idCardImage)
//        holder.serviceNameTv.textDirection = View.TEXT_DIRECTION_LOCALE

    }

    override fun getItemCount(): Int {
        return  idCardList.size
    }
}