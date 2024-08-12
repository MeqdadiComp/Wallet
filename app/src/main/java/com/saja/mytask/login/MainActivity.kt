package com.saja.mytask.login

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
//import android.telecom.Call
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
//import androidx.tracing.perfetto.handshake.protocol.Response
import com.google.android.material.textfield.TextInputEditText
import com.saja.mytask.ui.DashboardActivity
import com.saja.mytask.ui.ForgetPasswordActivity
import com.saja.mytask.R
import com.saja.mytask.login.model.TokenRequest
import com.saja.mytask.login.model.TokenResponse
import com.saja.mytask.login.repo.LoginRepo
import com.saja.mytask.network.ApiClient
import com.saja.mytask.network.ApiService
import com.saja.mytask.network.models.LoginResponse
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.network.models.TokenResultClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.saja.mytask.ui.RegisterActivity
import com.saja.mytask.utils.AuthInterceptorOkHttpClient
import com.saja.mytask.utils.Constant
import com.saja.mytask.utils.Constant.TEST_USER_NAME
import com.saja.mytask.utils.Constant.TEST_USER_PASSWORD
import com.saja.mytask.utils.WalletUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Named("APIService")
    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val forgetPassReset = findViewById<TextView>(R.id.forget)
        val create = findViewById<TextView>(R.id.create)
        val username = findViewById<TextInputEditText>(R.id.emailET)
        val button = findViewById<Button>(R.id.button)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordET)

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
                        applicationContext,
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
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordText.isEmpty()) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            LoginRepo.generateJwtToken(
                applicationContext,
                apiService
            ) { context: Context ->
                CoroutineScope(Dispatchers.IO).launch {
                    val bodyMap = mutableMapOf<String, String>()
                    bodyMap["username"] = Constant.TEST_USER_NAME
                    bodyMap["password"] = Constant.TEST_USER_PASSWORD
                    bodyMap["userHash"] = ""
                    bodyMap["userKey"] = ""
                    LoginRepo.login(context, apiService,bodyMap) { token : TokenResultClass ->
                        CoroutineScope(Dispatchers.Main).launch {
                            this@MainActivity.saveToken(token.user?.userKey ?: "")
                            val intent =
                                Intent(this@MainActivity, DashboardActivity::class.java)
                            startActivity(intent)
                            this@MainActivity.finish() // Finish the current activity to prevent going back to the login screen
                        }

                    }
                }
            }
        }

//                login()



//            val apiService = ApiClient.create()
//            val request = TokenRequest("5E2753718B1E99454A02C3633823B3D9")
//            val call: Call<TokenResponse> = apiService.getToken(request)
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
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        forgetPassReset.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        val shopImageView: ImageView = findViewById(R.id.merchant)
        val newWordTextView: TextView = findViewById(R.id.newWordTextView)

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

        val imageIcon: ImageView = findViewById(R.id.face_id)

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
    }

    private fun maskPassword(password: String): String {
        return "*".repeat(password.length)
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun saveToken(token: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }
}