package com.saja.mytask.ui.generateQr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.saja.mytask.databinding.FragmentGenerateQrBinding

class GenerateQrFragment : Fragment() {

    private var _binding: FragmentGenerateQrBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(GenerateQrViewModel::class.java)

        _binding = FragmentGenerateQrBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGenerateQr
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}