package com.saja.mytask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicesAdapter(private  val serviceList : List<Services>) : RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  serviceImageView : ImageView = itemView.findViewById(R.id.service1)
        val  serviceNameTv : TextView = itemView.findViewById(R.id.serviceName1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_service , parent , false)
        return ServiceViewHolder(view)

    }


    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val services = serviceList[position]
        holder.serviceImageView.setImageResource(services.serviceImage)
        holder.serviceNameTv.text = services.serviceName
//        holder.serviceNameTv.textDirection = View.TEXT_DIRECTION_LOCALE

    }

    override fun getItemCount(): Int {
        return  serviceList.size
    }
}