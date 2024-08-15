package com.saja.mytask.ui.base

import androidx.fragment.app.FragmentActivity
import com.saja.mytask.ui.dialogs.BaseProgressDialog
import javax.inject.Inject

open class ActivityBase : FragmentActivity() {
    @Inject
    lateinit var progressDialog: BaseProgressDialog

    fun showProgressDialog() {
        this.let {
            progressDialog.show(it.supportFragmentManager, BaseProgressDialog.DIALOG_TAG)
        }
    }

    fun hideProgressDialog() {
        this.let {
            progressDialog.dismissNow()
        }
    }
}
