// Un BroadcastReceiver en Kotlin (Android) est un composant qui permet à une application de
// recevoir et réagir à des messages système ou d’autres applications, appelés broadcasts.

package com.example.application01_12

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.karn.notify.Notify

class MainActivity : AppCompatActivity() {
    lateinit var txt: TextView
    lateinit var message: String

    // Vérification de permission NOTIFICATION
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            isGranted: Boolean ->
        if (isGranted) {
            envoyerNotification()
        } else {
            Toast.makeText(this, "Notification permission denied", Toast.LENGTH_SHORT).show()
        }
    }


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
            message = when {
                info == null -> "NO Internet/Wifi !.."
                info.type == ConnectivityManager.TYPE_WIFI -> "Connected to WiFi"
                info.type == ConnectivityManager.TYPE_MOBILE -> "Connected to Mobile Internet"
                else -> "Connected to another connection"
            }

            txt.text = message
            VerifierEtEnvoyer()
        }
    }

    // le main de fonction de notifiction qui dit : 
    // Si la permission "GRANTED" autorisé -> alors Appliquer la function "envoyerNotification"
    // Sinon repeter la question pour l'utilisateur ..
    private fun VerifierEtEnvoyer() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED ->
                {
                    envoyerNotification()
                }
                else -> {
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }

        }
        else {
            envoyerNotification()
        }
    }

    private fun envoyerNotification() {
        Notify.with(this)
            .content {
                title = "New Message"
                text = message
            }
            .show()
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
