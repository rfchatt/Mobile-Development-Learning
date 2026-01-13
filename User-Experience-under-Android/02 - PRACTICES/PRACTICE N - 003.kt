// Un BroadcastReceiver en Kotlin (Android) est un composant qui permet à une application de
// recevoir et réagir à des messages système ou d’autres applications, appelés broadcasts.

package com.example.application01_12

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.txt)

    }

    // Créer le récepteur
    var networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            // sevice de system
            var serviceDe_system = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            // récuperation des infos
            var info = serviceDe_system.activeNetworkInfo

            // message d'info
            var message = when {
                info == null -> "NO Internet/Wifi !.."
                info.type == ConnectivityManager.TYPE_WIFI -> "Connected to WiFi"
                info.type == ConnectivityManager.TYPE_MOBILE -> "Connected to Mobile Internet"
                else -> "Connected to another connection"
            }

            txt.text = message
        }
    }

    override fun onStart() {
        super.onStart()
        // 2. Dire au téléphone : "Écoute les changements de connectivité"
        var filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        // 3. Toujours arrêter l'écoute quand l'app est fermée
        unregisterReceiver(networkReceiver)
    }

}
