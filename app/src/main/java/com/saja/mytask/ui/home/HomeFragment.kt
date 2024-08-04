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
import com.saja.mytask.Transactions
import com.saja.mytask.TransactionsAdapter
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

    private lateinit var transactionsRecyclerView: RecyclerView
    private lateinit var transactionList: ArrayList<Transactions>
    private lateinit var transactionsAdapter: TransactionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()
        initIdCard()
        initTransactions()

        return root
    }

    private fun initRecyclerView() {
        recyclerView = binding.cardRecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        servicesList = ArrayList()

        addDataToList()
        servicesAdapter = ServicesAdapter(servicesList)
        recyclerView.adapter = servicesAdapter

        val itemHeight = resources.getDimensionPixelSize(R.dimen.dashboard_item_height)
        val totalHeight = itemHeight * 5
        recyclerView.layoutParams.width = totalHeight
        recyclerView.requestLayout()
    }

    private fun addDataToList() {
        servicesList.add(Services(R.drawable.bill, "Pay Bill"))
        servicesList.add(Services(R.drawable.transaction, "Send Money"))
        servicesList.add(Services(R.drawable.cards, "Topup"))
        servicesList.add(Services(R.drawable.bill, "Split Bill"))
        servicesList.add(Services(R.drawable.cliqlogo, "Saving"))
        servicesList.add(Services(R.drawable.cards, "Topup"))
        servicesList.add(Services(R.drawable.bill, "Split Bill"))
        servicesList.add(Services(R.drawable.cliqlogo, "Saving"))
        servicesList.add(Services(R.drawable.cards, "Topup"))
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
        idCardList.add(IdCard(R.drawable.id1))
        idCardList.add(IdCard(R.drawable.id1))
        idCardList.add(IdCard(R.drawable.id2))

    }

    private fun initTransactions() {
        transactionsRecyclerView = binding.transactionRecyclerView
        transactionsRecyclerView.setHasFixedSize(true)
        transactionsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(transactionsRecyclerView)
        transactionList = ArrayList()

        addDataToTransactionsList()
        transactionsAdapter = TransactionsAdapter(transactionList)
        transactionsRecyclerView.adapter = transactionsAdapter

        val itemHeight = resources.getDimensionPixelSize(R.dimen.dashboard_item_height)
        val totalHeight = itemHeight * 4
        transactionsRecyclerView.layoutParams.height = totalHeight
        transactionsRecyclerView.requestLayout()
    }

    private fun addDataToTransactionsList() {
        transactionList.add(Transactions("CliQ Payment","04 OCT 2024","330.000 JO"))
        transactionList.add(Transactions("Bill Payment","21 FEB 2024","+150.000 JOD"))
        transactionList.add(Transactions("CliQ Payment","22 FEB 2024","+330.000 JOD"))
        transactionList.add(Transactions("Bill Payment","23 FEB 2024","+560.000 JOD"))
        transactionList.add(Transactions("CliQ Payment","24 FEB 2024","+150.000 JOD"))
        transactionList.add(Transactions("Bill Payment","25 FEB 2024","+230.000 JOD"))
        transactionList.add(Transactions("CliQ Payment","26 FEB 2024","+3415.000 JOD"))
        transactionList.add(Transactions("Bill Payment","27 FEB 2024","+870.000 JOD"))
        transactionList.add(Transactions("CliQ Payment","28 FEB 2024","+350.000 JOD"))
        transactionList.add(Transactions("Bill Payment","29 FEB 2024","+1460.6400 JOD"))
        transactionList.add(Transactions("CliQ Payment","01 MARC 2024","+890.040 JOD"))
        transactionList.add(Transactions("Bill Payment","02 MARC 2024","+430.706 JOD"))
        transactionList.add(Transactions("CliQ Payment","03 MARC 2024","+670.045 JOD"))
        transactionList.add(Transactions("Bill Payment","04 MARC 2024","+230.000 JOD"))
        transactionList.add(Transactions("CliQ Payment","05 MARC 2024","+9960.100 JOD"))
        transactionList.add(Transactions("Bill Payment","06 MARC 2024","+150.050 JOD"))
        transactionList.add(Transactions("CliQ Payment","07 MARC 2024","+450.000 JOD"))
        transactionList.add(Transactions("Bill Payment","08 MARC 2024","+980.070 JOD"))
        transactionList.add(Transactions("CliQ Payment","09 MARC 2024","+2530.430 JOD"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
