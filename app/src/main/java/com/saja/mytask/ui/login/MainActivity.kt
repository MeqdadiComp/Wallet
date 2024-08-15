package com.saja.mytask.ui.login

import android.app.ProgressDialog
import android.os.Bundle
//import android.telecom.Call
import androidx.fragment.app.FragmentActivity
//import androidx.tracing.perfetto.handshake.protocol.Response
import com.saja.mytask.databinding.MainActivityBinding
import com.saja.mytask.ui.base.ActivityBase
import com.saja.mytask.ui.dialogs.BaseProgressDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ActivityBase() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}