package com.saja.mytask.ui.cliq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.saja.mytask.R
import com.saja.mytask.databinding.FragmentCliqRequestListBinding
import com.saja.mytask.databinding.FragmentCliqSendPaymentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CliQRequestListFragment : Fragment() {

    private var _binding: FragmentCliqRequestListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<CliqRequestListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cliqSendPaymentViewModel =
            ViewModelProvider(this).get(CliqSendPaymentViewModel::class.java)

        _binding = FragmentCliqRequestListBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = this@CliQRequestListFragment.viewModel
            lifecycleOwner = this@CliQRequestListFragment
        }
        val root: View = binding.root

        binding.rgRequestType.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = root.findViewById<RadioButton>(checkedId)
            if (radioButton != null && radioButton.id.equals(binding.rbIncomingRequests.id)) {
                binding.rvIncomingRequest.visibility = View.VISIBLE
                binding.rvOutgoingRequest.visibility = View.GONE
            }
            else {
                binding.rvIncomingRequest.visibility = View.GONE
                binding.rvOutgoingRequest.visibility = View.VISIBLE
            }
        }

//        cliqSendPaymentViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}