package com.saja.mytask.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.saja.mytask.R
import com.saja.mytask.models.Services

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
        holder.itemView.setOnClickListener {
            when (services.serviceName) {
                "CliQ Send" -> {
                    // Handle CliQ Send click
//                    val intent = Intent(WalletApplication.getInstance().applicationContext, CliQSendPaymentActivity::class.java)
//                    WalletApplication.getInstance().applicationContext.startActivity(intent)
                   holder.itemView.findNavController().navigate(R.id.navigation_send_cliq_payment)

                    Log.i("ServicesAdapter", "CliQ Send clicked")
                }

                "CliQ Request" -> {
                    // Handle CliQ Request click
                    Log.i("ServicesAdapter", "CliQ Request clicked")
                }
            }
//        holder.serviceNameTv.textDirection = View.TEXT_DIRECTION_LOCALE

        }


        // Handle Efawatercom
        holder.serviceImageView.setImageResource(services.serviceImage)
        holder.serviceNameTv.text = services.serviceName

        if (services.serviceName == "Efwateercom") {
            holder.itemView.setOnClickListener {
                it.findNavController().navigate(R.id.mainEfawatercomFragment)
            }
        } else {
            holder.itemView.setOnClickListener(null)
        }
    }

    override fun getItemCount(): Int {
        return  serviceList.size
    }
}