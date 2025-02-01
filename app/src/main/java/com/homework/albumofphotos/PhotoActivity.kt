package com.homework.albumofphotos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.Button
import android.widget.ImageView



class PhotoActivity : AppCompatActivity() {

    private val photos = arrayOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
        R.drawable.photo5
    )

    private var currentPhotoIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView: ImageView = findViewById(R.id.imageViewPhoto)
        val nextPhotoButton: Button = findViewById(R.id.buttonNextPhoto)

        imageView.clipToOutline = true
        imageView.setImageResource(photos[currentPhotoIndex])

        nextPhotoButton.setOnClickListener {
            if (currentPhotoIndex < photos.size - 1) {
                currentPhotoIndex++
                imageView.setImageResource(photos[currentPhotoIndex])
            } else {
                val intent = Intent(this, FinalActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}