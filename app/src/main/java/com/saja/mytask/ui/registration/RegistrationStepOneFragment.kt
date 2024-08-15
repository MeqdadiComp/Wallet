package com.saja.mytask.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.saja.mytask.databinding.RegistrationStepOneFragmentBinding
import com.saja.mytask.network.ServiceApi
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class RegistrationStepOneFragment : Fragment(), FragmentComponent {
//    @Named("APIService")
//    @Inject
//    lateinit var serviceApi: ServiceApi

    private val registrationViewModel: RegistrationViewModel by viewModels()


    private var _binding: RegistrationStepOneFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val loginViewModel =
//            ViewModelProvider(this)[RegistrationViewModel::class.java]

        _binding = RegistrationStepOneFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun maskPassword(password: String): String {
        return "*".repeat(password.length)
    }

    private fun showAlert(title: String, message: String) {
        val builder = this.activity?.baseContext?.let { AlertDialog.Builder(it) }
        builder?.setTitle(title)
        builder?.setMessage(message)
        builder?.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder?.create()
        dialog?.show()
    }

//    private fun saveToken(token: String) {
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putString("token", token)
//        editor.apply()
//    }
}