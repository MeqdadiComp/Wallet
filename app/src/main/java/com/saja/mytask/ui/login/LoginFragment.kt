package com.saja.mytask.ui.login

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saja.mytask.R
import com.saja.mytask.databinding.LoginFragmentBinding
import com.saja.mytask.network.models.LoginResponse
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.ui.DashboardActivity
import com.saja.mytask.ui.ForgetPasswordActivity
import com.saja.mytask.utils.Constant.TEST_USER_NAME
import com.saja.mytask.utils.Constant.TEST_USER_PASSWORD
import com.saja.mytask.utils.DataState
import com.saja.mytask.utils.WalletUtils
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginFragment : Fragment(), FragmentComponent {
//    @Named("APIService")
//    @Inject
//    lateinit var serviceApi: ServiceApi


    private val viewModel: LoginViewModel by viewModels()

    private var _binding: LoginFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        subscribeObservers()


        val forgetPassReset = binding.forget
        val create = binding.create
        val username = binding.emailET
        val button = binding.button
        val passwordEditText = binding.passwordET

        //new for api
        username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val usernameET = s.toString()
                if (usernameET.length == 10 && !usernameET.startsWith("07")) {
                    // If the length is 10 and doesn't start with "07", clear the EditText
//                    username.setText("")
//                    username.error = "Username must start with '07' "
//                    showAlert("Invalid Username", "Username must start with '07'")
                    Toast.makeText(
                        this@LoginFragment.activity?.applicationContext,
                        "Username must start with '07'",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        })

        button.setOnClickListener {
            username.setText(TEST_USER_NAME)
            passwordEditText.setText(TEST_USER_PASSWORD)

            // Get the entered username and password
            val usernameText = username.text.toString().trim()
            val passwordText = passwordEditText.text.toString().trim()

            if (usernameText.isEmpty()) {
                Toast.makeText(this.context, "Please enter your username", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (passwordText.isEmpty()) {
                Toast.makeText(this.context, "Please enter your password", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            viewModel.setStateEvent(MainStateEvent.GetJwtTokenEvent)

//            MainRepository.generateJwtToken(
//                this@LoginFragment.requireActivity().applicationContext,
//                serviceApi
//            ) { context: Context ->
//                CoroutineScope(Dispatchers.IO).launch {
//                    val bodyMap = mutableMapOf<String, String>()
//                    bodyMap["username"] = Constant.TEST_USER_NAME
//                    bodyMap["password"] = Constant.TEST_USER_PASSWORD
//                    bodyMap["userHash"] = ""
//                    bodyMap["userKey"] = ""
//                    LoginRepository.login(context, serviceApi,bodyMap) { token : TokenResultClass ->
//                        CoroutineScope(Dispatchers.Main).launch {
////                            saveToken(token.user?.userKey ?: "")
//                            val intent =
//                                Intent(this@LoginFragment.activity, DashboardActivity::class.java)
//                            startActivity(intent)
//                            this@LoginFragment.activity?.finish() // Finish the current activity to prevent going back to the login screen
//                        }
//
//                    }
//                }
//            }
        }

//                login()


//            val serviceApi = ApiClient.create()
//            val request = TokenRequest("5E2753718B1E99454A02C3633823B3D9")
//            val call: Call<TokenResponse> = serviceApi.getToken(request)
//
//            call.enqueue(object : Callback<TokenResponse> {
//                override fun onResponse(
//                    call: Call<TokenResponse>,
//                    response: Response<TokenResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        val tokenResponse = response.body()
//                        val token = tokenResponse?.response?.token
//                        if (token != null) {
//                            // Save the token for future use, maybe in shared preferences or in a global variable
//                            saveToken(token)
//                            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
//                            startActivity(intent)
//                            finish() // Finish the current activity to prevent going back to the login screen
//
//
//                        } else {
//                            // Handle the case when token is null
//                            Toast.makeText(
//                                applicationContext,
//                                "Token is null",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    } else {
//                        // Handle unsuccessful response
//                        Toast.makeText(
//                            applicationContext,
//                            "Failed to get token: ${response.errorBody()?.string()}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
//                    // Handle failure
//                    Toast.makeText(
//                        applicationContext,
//                        "Error fetching token: ${t.message}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            })

//        button.setOnClickListener { //
//            val usernameText = username.text.toString().trim()
//            val passwordText = passwordEditText.text.toString().trim()
//
//            if (usernameText.isEmpty()) {
//                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (passwordText.isEmpty()) {
//                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Proceed with your login logic here
//            val intent = Intent(this, DashboardActivity::class.java)
//            startActivity(intent)
//
//
//        }

        create.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registration_step_one_fragment)
//            val intent = Intent(this.activity, RegisterActivity::class.java)
//            startActivity(intent)
        }
        forgetPassReset.setOnClickListener {
            val intent = Intent(this.activity, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        val shopImageView: ImageView = binding.merchant
        val newWordTextView: TextView = binding.newWordTextView

        val originalIcon = R.drawable.shop
        val alternateIcon = R.drawable.customer_merchant
        val originalWord = ""
        val newWord = getString(R.string.text)

        shopImageView.setOnClickListener {
            if (shopImageView.tag == originalIcon) {
                shopImageView.setColorFilter(Color.WHITE)
                // Change the icon and display the new word
                shopImageView.setImageResource(alternateIcon)
                newWordTextView.text = newWord
            } else {
                // Revert back to the original icon and word
                shopImageView.setImageResource(originalIcon)
                shopImageView.setColorFilter(Color.WHITE)
                newWordTextView.text = originalWord
            }
            shopImageView.tag =
                if (shopImageView.tag == originalIcon) alternateIcon else originalIcon

        }

//        val imageIcon: ImageView = findViewById(R.id.face_id)
        val imageIcon = binding.faceId

        // Define the initial color of the icon
        val initialColor = Color.GRAY

        // Set a click listener for the icon
        imageIcon.setOnClickListener {
            // Change the color of the icon when clicked
            imageIcon.setColorFilter(Color.WHITE) // Change to your desired color
            // Define the scale animation to make the icon expand
            val scaleAnimation = ScaleAnimation(
                1.0f, 1.5f, // From X scale to X scale
                1.0f, 1.5f, // From Y scale to Y scale
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot X coordinate (center)
                Animation.RELATIVE_TO_SELF, 0.5f // Pivot Y coordinate (center)
            )

            // Set the duration of the animation
            scaleAnimation.duration = 2000 // Change to your desired duration in milliseconds
            scaleAnimation.interpolator = OvershootInterpolator()
            // Set listener for animation end
            scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {
                    // Restore the original scale after the animation ends
                    imageIcon.clearAnimation()
                    imageIcon.scaleX = 1.0f
                    imageIcon.scaleY = 1.0f

                    // Restore the original color after the animation ends
                    imageIcon.setColorFilter(initialColor)
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })

            // Start the scale animation
            imageIcon.startAnimation(scaleAnimation)
        }


        // Set the input type to password
        passwordEditText.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()
                val maskedPassword = maskPassword(password)

                if (password != maskedPassword) {  // Only update if there's a change
                    passwordEditText.removeTextChangedListener(this)
                    passwordEditText.setText(maskedPassword)
                    passwordEditText.setSelection(maskedPassword.length)
                    passwordEditText.addTextChangedListener(this)
                }
            }
        })

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

    private fun displayError(message: String?) {
        if (message.isNullOrEmpty()) {
            Toast.makeText(this.activity, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this.activity, "Unknown error", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayLoading(isLoading: Boolean) {
        when (isLoading) {
            true -> (this.requireActivity() as MainActivity).showProgressDialog()
            false -> (this.requireActivity() as MainActivity).hideProgressDialog()
        }
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<String> -> {
                    //                            // Save the JWT token for future use
                    WalletUtils.saveAuthorizationJWTToken(this.requireContext(), dataState.data)
                    displayLoading(false)
                    viewModel.setStateEvent(MainStateEvent.LoginEvent)
                }

                is DataState.Loading -> {
                    displayLoading(true)
                }

                is DataState.Error -> {
                    displayLoading(false)
                    displayError(dataState.exception.message)
                }
            }
        })


        viewModel.loginDataState.observe(viewLifecycleOwner, Observer { loginDataState ->
            when (loginDataState) {
                is DataState.Success<ResponseBaseModel<LoginResponse>> -> {
                    // Save the User data for future use
//                    loginDataState.data.result
                    displayLoading(false)
                    val intent = Intent(this@LoginFragment.activity, DashboardActivity::class.java)
                    startActivity(intent)
                    this.requireActivity().finish() // Finish the current activity to prevent going back to the login screen
//
                }

                is DataState.Loading -> {
                    displayLoading(true)
                }

                is DataState.Error -> {
                    displayLoading(false)
                    displayError(loginDataState.exception.message)
                }
            }
        })
    }
}