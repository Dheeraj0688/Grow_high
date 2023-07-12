package com.example.dheeraj_sahu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Thirdfragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_third_screen) // Set the feeds.xml layout here
        val progress1: ImageView =findViewById(R.id.progressbar)
        progress1.setOnClickListener {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }
        val skipbtn: Button = findViewById(R.id.skipbtn)
        skipbtn.setOnClickListener {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }
    }

    // ...
}