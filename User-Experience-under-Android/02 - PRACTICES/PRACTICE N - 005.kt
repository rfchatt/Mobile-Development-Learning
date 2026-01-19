package com.example.tp10_11

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //
        val startButton = findViewById<MaterialButton>(R.id.btnDownload)
        val progressBar = findViewById<ProgressBar>(R.id.downloadProgressBar)
        val statusTextView = findViewById<TextView>(R.id.statusTextView)

        startButton.setOnClickListener {
            startButton.isEnabled = false  // Disable button after the click

            // استدعاء دالة coroutines
            lifecycleScope.launch {
                simulateDownload(progressBar, statusTextView)

                startButton.isEnabled = true // Enable button after finish
            }
        }

    }

    // coroutines function that start with `suspend`
    private suspend fun simulateDownload(progressBar: ProgressBar, statusText: TextView) {
        for (i in 1..10) {
            val progress = i * 10

            delay(500)

            progressBar.progress = progress
            statusText.text = "Téléchargement en cours : $progress%"
        }

        statusText.text = "Téléchargement terminé !"
    }


}
