// TP 8 EX - 1

// -------- | MainActivity | --------

package com.example.tp8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.ViewCompat
import androidx.work.OneTimeWorkRequestBuilder
import androidx.core.view.WindowInsetsCompat
import androidx.work.NetworkType
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 2.Requéts
        val workRequest = OneTimeWorkRequestBuilder<logWorker>().build()

        // 3.Envoyer a WorkManager
        WorkManager.getInstance(this).enqueue(workRequest)

    }
}

// -------- | logWorker | --------

package com.example.tp8

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.work.WorkerParameters
import androidx.work.Worker

class logWorker (applicationContext: Context, parameters: WorkerParameters) : Worker (applicationContext, parameters) {

    var handler = Handler(Looper.getMainLooper())

    override fun doWork(): Result {
        return try{
            handler.post {
                Log.d("WorkManagerLog", "Welcome back !")
            }
            Result.success()
        }
        catch (e: Exception) {
            Log.d("","Erreur $e")
            Result.failure()
        }
    }

}
