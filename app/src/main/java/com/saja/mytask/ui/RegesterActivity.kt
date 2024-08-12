package com.saja.mytask.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.saja.mytask.R
import com.saja.mytask.login.MainActivity

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.regester)

        val nationalSpinner: Spinner = findViewById(R.id.nationality)
        val nationalAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.nationality_list,
            android.R.layout.simple_spinner_item
        )
        nationalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        nationalSpinner.adapter = nationalAdapter

        val citySpinner: Spinner = findViewById(R.id.city)
        val cityAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.city_list,
            android.R.layout.simple_spinner_item
        )
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.adapter = cityAdapter

        val nationalIDEditText: TextInputEditText = findViewById(R.id.nationalIDET)

        nationalSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                nationalIDEditText.hint = if (selectedItem == "Jordan") {
                    "National ID"
                } else {
                    "Document ID"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        val signTextView: TextView = findViewById(R.id.signInLink)
        signTextView.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val openOtpDialogButton: Button = findViewById(R.id.nextButton)
        openOtpDialogButton.setOnClickListener {
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
            Toast.makeText(this@RegisterActivity, "Resending OTP...", Toast.LENGTH_SHORT).show()
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
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1 && i < editTexts.size - 1) {
                        editTexts[i + 1].requestFocus()
                    } else if (s?.length == 0 && i > 0) {
                        editTexts[i - 1].requestFocus()
                    }

                    if (i == editTexts.size - 1 && s?.length == 1) {
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
            val intent = Intent(this, BottomSheetActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
        }
    }
}
