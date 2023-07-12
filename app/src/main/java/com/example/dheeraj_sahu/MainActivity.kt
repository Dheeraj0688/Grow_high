package com.example.dheeraj_sahu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var isFirstLaunch = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true)

        if (isFirstLaunch) {
            setContentView(R.layout.activity_main)
            val progress1: ImageView = findViewById(R.id.progressbar)
            progress1.setOnClickListener {
                val intent = Intent(this, Secondfragment::class.java)
                startActivity(intent)
            }
            val skipbtn: Button = findViewById(R.id.skipbtn)
            skipbtn.setOnClickListener {
                val intent = Intent(this, User::class.java)
                startActivity(intent)
            }

            // Add your code for introduction screens here

            sharedPreferences.edit().putBoolean("isFirstLaunch", false).apply()
        } else {
            navigateToMainScreen()
        }
    }

    private fun navigateToMainScreen() {
        setContentView(R.layout.user)
        val feedBtn: ImageView = findViewById(R.id.feedbtn)
        feedBtn.setOnClickListener {
            val intent = Intent(this, FeedsActivity::class.java)
            startActivity(intent)
        }

        val uploadbtn: ImageView = findViewById(R.id.uploadbtn)
        uploadbtn.setOnClickListener {
            val intent = Intent(this, Upload::class.java)
            startActivity(intent)
        }
        // Or, start your main activity
        // val intent = Intent(this, YourMainActivity::class.java)
        // startActivity(intent)
        // finish()
    }
}
