package com.saja.mytask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.saja.mytask.login.MainActivity

class WelcomeEwalletActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_ewallet_activity)

        val helloTextView = findViewById<TextView>(R.id.eWallet)
        helloTextView.text = " e Wallet"

        // Automatically move to MainActivity after a delay
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

}