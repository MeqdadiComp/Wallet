package com.saja.mytask

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog

class ForgetPasswordActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_password_activity)
       // setContentView(R.layout.succsess_reset_pass)

        val reset = findViewById<Button>(R.id.finishButton)
        reset.setOnClickListener {
            showOtpDialog()
        }
    }

    private fun showOtpDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_otp, null)
        val otpDigit1: EditText = dialogView.findViewById(R.id.otpDigit1)
        val otpDigit2: EditText = dialogView.findViewById(R.id.otpDigit2)
        val otpDigit3: EditText = dialogView.findViewById(R.id.otpDigit3)
        val otpDigit4: EditText = dialogView.findViewById(R.id.otpDigit4)
        val resendOtp: TextView = dialogView.findViewById(R.id.resendOtp)

        setupOtpEditTexts(otpDigit1, otpDigit2, otpDigit3, otpDigit4)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        resendOtp.setOnClickListener {
            Toast.makeText(
                this@ForgetPasswordActivity,
                "Resending OTP...",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }

    private fun setupOtpEditTexts(vararg editTexts: EditText) {
        for (i in editTexts.indices) {
            val editText = editTexts[i]
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    if (s?.length == 1 && i < editTexts.size - 1) {
                        editTexts[i + 1].requestFocus()
                    } else if (s?.length == 0 && i > 0) {
                        editTexts[i - 1].requestFocus()
                    }

                    if (editTexts.all { it.text.length == 1 }) {
                        val otp = editTexts.joinToString("") { it.text.toString() }
                        verifyOtp(otp)
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }

    private fun verifyOtp(otp: String) {
        if (otp == "1234") {
            val intent = Intent(this, SuccessBoxActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
        }
    }
}
