package com.saja.mytask.ui.cliq

import com.saja.mytask.R
import com.saja.mytask.databinding.FragmentCliqRequestItemBinding
import com.saja.mytask.utils.base.BaseAdapter

class CliqRequestAdapter(
    list: List<CliqRequestModel>,
    private val cliQRequestListener: CliQRequestListener
) : BaseAdapter<FragmentCliqRequestItemBinding, CliqRequestModel>(list) {

    override val layoutId: Int = R.layout.fragment_cliq_request_item

    override fun bind(binding: FragmentCliqRequestItemBinding, item: CliqRequestModel) {
        binding.apply {
            request = item
            listener = cliQRequestListener
            executePendingBindings()
        }
    }
}