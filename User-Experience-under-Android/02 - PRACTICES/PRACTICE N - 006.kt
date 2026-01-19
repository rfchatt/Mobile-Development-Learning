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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var statusText: TextView
    private lateinit var btn: MaterialButton
    private var stock = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.ProgressBar)
        statusText = findViewById(R.id.Text)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {

            btn.isEnabled = false
            stock = 0

            val simulationJob = lifecycleScope.launch {
                launch {
                    while (true) {
                        delay(500)
                        if (stock < 10) {
                            stock++
                            statusText.text = ("[Producteur] | Le Stock : $stock")
                        }
                    }
                }
                launch {
                    while (true) {
                        delay(300)
                        if (stock > 0) {
                            stock--
                            statusText.text = ("[Consomateur] | Le Stock : $stock")
                        }
                    }
                }
                delay(20000)
            }


            simulationJob.invokeOnCompletion {
                statusText.text = "Simulation terminée"
                btn.isEnabled = true
            }

        }
    }

}
