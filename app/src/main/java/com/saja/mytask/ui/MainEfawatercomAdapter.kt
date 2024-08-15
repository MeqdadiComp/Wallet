package com.saja.mytask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.saja.mytask.models.Services

class MainEfawatercomAdapter(private val serviceList: List<Services>) : RecyclerView.Adapter<MainEfawatercomAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serviceImageView: ImageView = itemView.findViewById(R.id.service1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val services = serviceList[position]
        holder.serviceImageView.setImageResource(services.serviceImage)

        if (services.serviceName == "Efwateercom") {
            holder.itemView.setOnClickListener {
                it.findNavController().navigate(R.id.efawateercomFragment)
            }
        } else {
            holder.itemView.setOnClickListener(null)
        }
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }
}
