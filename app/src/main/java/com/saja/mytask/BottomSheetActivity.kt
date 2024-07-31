package com.saja.mytask

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class BottomSheetActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_sheet)

        val passVerified: TextView = findViewById(R.id.create_verified_button)
        passVerified.setOnClickListener{
            val intent = Intent(this, CreatePasswordActivity::class.java)
            startActivity(intent)
        }

    }
}
