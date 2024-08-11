package com.saja.mytask

import PurchasingPopupDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.switchmaterial.SwitchMaterial

class MyCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_card, container, false)

        val switchNfcStatus = view.findViewById<SwitchMaterial>(R.id.switchNfcStatus)

        switchNfcStatus.setOnClickListener {
            showPopup()
        }

        return view
    }

    private fun showPopup() {
        val popupFragment = PurchasingPopupDialog()
        popupFragment.show(parentFragmentManager, "popupFragment")
    }
}
