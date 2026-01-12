package com.example.savestateapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var edt: TextInputEditText
    private lateinit var btn: MaterialButton
    private lateinit var txt: TextView

    // 1. Récupération des données si l'activité est recréée
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edt = findViewById(R.id.edt_name)
        btn = findViewById(R.id.btn)
        txt = findViewById(R.id.txt)

        btn.setOnClickListener {
            val name = edt.text.toString()
            txt.text = "Hello, $name!"
        }

        if (savedInstanceState != null) {
            txt.text = savedInstanceState.getString("HELLO_NAME")
        }

    }

    // 2. SAUVEGARDE : Appelé avant que l'activité ne soit détruite
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("HELLO_NAME", txt.text.toString())
    }

}
