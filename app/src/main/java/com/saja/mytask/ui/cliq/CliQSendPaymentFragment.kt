package com.saja.mytask.ui.cliq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.saja.mytask.R
import com.saja.mytask.databinding.FragmentCliqSendPaymentBinding

class CliQSendPaymentFragment : Fragment() {

    private var _binding: FragmentCliqSendPaymentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cliqSendPaymentViewModel =
            ViewModelProvider(this).get(CliqSendPaymentViewModel::class.java)

        _binding = FragmentCliqSendPaymentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rgAliasType.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = root.findViewById<RadioButton>(checkedId)
            if (radioButton != null && radioButton.id.equals(binding.rbAlias.id)) {
                binding.etAliasValue.hint = getString(R.string.alias_value)
            }
            else {
                binding.etAliasValue.hint = getString(R.string.mobile)
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