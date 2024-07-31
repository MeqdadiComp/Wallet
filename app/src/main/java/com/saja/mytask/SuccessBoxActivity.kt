package com.saja.mytask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SuccessBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.succsess_chick_box)

        // Auto navigate to createPasswordActivity after showing the success msg
        Handler(Looper.getMainLooper())
            .postDelayed({
            val intent = Intent(this, CreatePasswordActivity::class.java)
            startActivity(intent)
            finish()  // Finish this activity so the user cant return to it
        }, 1000)  // 3s delay
    }
}

