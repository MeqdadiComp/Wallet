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
import com.saja.mytask.QiuckTransaction
import com.saja.mytask.QuickTransactionAdapter
import com.saja.mytask.R
import com.saja.mytask.adapters.IdCardAdapter
import com.saja.mytask.adapters.ServicesAdapter
import com.saja.mytask.adapters.TransactionsAdapter
import com.saja.mytask.models.IdCard
import com.saja.mytask.models.Services
import com.saja.mytask.models.Transactions
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


    private lateinit var quickTransactionRecyclerView: RecyclerView
    private lateinit var quickTransactionList: ArrayList<QiuckTransaction>
    private lateinit var quickTransactionAdapter: QuickTransactionAdapter


//    private lateinit var idRecyclerView: MaterialCardView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val view: View = inflater.inflate(R.layout.fragment_home,container,false)
//        idRecyclerView= view.findViewById(R.id.idRecyclerView)
//        return view

        _binding = FragmentHomeBinding.inflate(inflater, container , false)
        val root: View = binding.root

        initRecyclerView()
        initIdCard()
        initTransactions()
        initQuickTransactionRecyclerView()

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
        servicesList.add(Services(0, "Pay Bill"))
        servicesList.add(Services(0, "Click Send"))
        servicesList.add(Services(0, "Click Request"))
        servicesList.add(Services(0, "Efwateercom"))
    }


    private fun initQuickTransactionRecyclerView() {
        quickTransactionRecyclerView = binding.quickTransactionRecyclerView
        quickTransactionRecyclerView.setHasFixedSize(true)
        quickTransactionRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(quickTransactionRecyclerView)
        quickTransactionList = ArrayList()

        addDataToQuickTransactionList()
        quickTransactionAdapter = QuickTransactionAdapter(quickTransactionList)
        quickTransactionRecyclerView.adapter = quickTransactionAdapter

        val itemHeight = resources.getDimensionPixelSize(R.dimen.dashboard_item_height)
        val totalHeight = itemHeight * 5
        quickTransactionRecyclerView.layoutParams.width = totalHeight
        quickTransactionRecyclerView.requestLayout()
    }

    private fun addDataToQuickTransactionList() {
        quickTransactionList.add(QiuckTransaction(0, "SL"))
        quickTransactionList.add(QiuckTransaction(0, "SA"))
        quickTransactionList.add(QiuckTransaction(0, "GW"))
        quickTransactionList.add(QiuckTransaction(0, "RM"))

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        binding.idRecyclerView.setOnClickListener {
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
