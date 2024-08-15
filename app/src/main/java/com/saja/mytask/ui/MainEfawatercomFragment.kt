package com.saja.mytask.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.saja.mytask.R

class MainEfawatercomFragment : Fragment() {

    private val viewModel: MainEfawatercomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main_efawatercom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val unpaidBillBtn: Button = view.findViewById(R.id.unpaidBill_btn)
        unpaidBillBtn.setOnClickListener {
            findNavController().navigate(R.id.efawateercomFragment)
        }
    }
}
