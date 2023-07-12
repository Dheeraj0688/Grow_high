package com.example.dheeraj_sahu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class User : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user) // Set the feeds.xml layout here
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
    }

    // ...
}
