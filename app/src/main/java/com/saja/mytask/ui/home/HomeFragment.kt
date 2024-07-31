package com.saja.mytask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.saja.mytask.IdCard
import com.saja.mytask.IdCardAdapter
import com.saja.mytask.R
import com.saja.mytask.Services
import com.saja.mytask.ServicesAdapter
import com.saja.mytask.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var servicesList: ArrayList<Services>
    private lateinit var servicesAdapter: ServicesAdapter

    private lateinit var cardRecyclerView: RecyclerView
    private lateinit var idCardList: ArrayList<IdCard>
    private lateinit var idCardAdapter: IdCardAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()
        initIdCard()

        return root
    }

    private fun initRecyclerView() {
        recyclerView = binding.cardRecyclerView // Adjust this line to use the correct ID from your layout
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        servicesList = ArrayList()

        addDataToList()
        servicesAdapter = ServicesAdapter(servicesList)
        recyclerView.adapter = servicesAdapter
    }

    private fun addDataToList() {
        servicesList.add(Services(R.drawable.bill, "Pay Bill"))
        servicesList.add(Services(R.drawable.transaction, "Send Money"))
        servicesList.add(Services(R.drawable.cards, "Topup"))
        servicesList.add(Services(R.drawable.bill, "Split Bill"))
        servicesList.add(Services(R.drawable.cliqlogo, "Saving"))
    }

    private fun initIdCard() {
        cardRecyclerView = binding.idRecyclerView
        cardRecyclerView.setHasFixedSize(true)
        cardRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(cardRecyclerView)
        idCardList = ArrayList()

        addDataToIdCardList()
        idCardAdapter = IdCardAdapter(idCardList)
        cardRecyclerView.adapter = idCardAdapter
    }

    private fun addDataToIdCardList() {
        idCardList.add(IdCard(R.drawable.credit_gradiant))
        idCardList.add(IdCard(R.drawable.id1))
        idCardList.add(IdCard(R.drawable.id2))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
