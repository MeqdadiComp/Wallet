package com.saja.mytask.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.saja.mytask.R

class BaseProgressDialog : DialogFragment() {

    companion object {
        const val DIALOG_TAG = "BaseProgressDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it, R.style.MainAlertDialog)
            val inflater = requireActivity().layoutInflater
            val dialogView = inflater.inflate(R.layout.progress_dialog, null)

            with(builder) {

                setView(dialogView)
                create()
            }
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setCancelable(false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val size = resources.getDimensionPixelSize(R.dimen.size_80dp)
        dialog?.window?.setLayout(size, size)
    }
}