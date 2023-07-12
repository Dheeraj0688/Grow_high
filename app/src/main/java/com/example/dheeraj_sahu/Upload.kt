package com.example.dheeraj_sahu

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStream

class Upload : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var galleryImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload)

        galleryImageView = findViewById(R.id.uploadselect)
        galleryImageView.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            if (selectedImageUri != null) {
                displaySelectedImage(selectedImageUri)
            }
        }
    }

    private fun displaySelectedImage(imageUri: Uri) {
            val inputStream: InputStream? = contentResolver.openInputStream(imageUri)
            val bitmap: Bitmap? = BitmapFactory.decodeStream(inputStream)
            val galleryImageView: ImageView = findViewById(R.id.galary) // Replace with your ImageView ID
            galleryImageView.setImageBitmap(bitmap)
        }
    }
