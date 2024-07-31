package com.saja.mytask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.saja.mytask.login.MainActivity

class CreatePasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_pass_activity)

//        val x = findViewById<Button>(R.id.finishButton)
//        x.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)



//            val finishButton = findViewById<Button>(R.id.finishButton)
//            finishButton.setOnClickListener {
//                val intent = Intent(this, SuccessCreateActivity::class.java)
//                startActivity(intent)


                val finishButton = findViewById<Button>(R.id.finishButton)
                finishButton.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()  // Finish this activity so the user cant return to it


        }
    }
}