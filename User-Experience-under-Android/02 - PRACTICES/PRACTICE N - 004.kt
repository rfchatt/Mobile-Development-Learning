// TP 8 EX - 1

// -------- | MainActivity | --------

package com.example.workmanager_tp8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btn = findViewById<MaterialButton>(R.id.btn)

        btn.setOnClickListener {

            // ici les 3 elements de WorkManager dans MainActivity : [Constraints, workRequest et WorkManager]

            // I: Constraints -> الشروط
            var constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            // II: Requête ->
            var workRequest = OneTimeWorkRequestBuilder<myWorker>()
                .setConstraints(constraints)
                .build()

            // III: Envoyer to WorkManager
            WorkManager.getInstance(this).enqueue(workRequest)

        }

    }
}

// -------- | myWorker | --------

package com.example.workmanager_tp8

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

var WorkerManager = "WorkerManager"

class myWorker (appContext: Context, workerParams: WorkerParameters) : Worker (appContext, workerParams) {

    // ici la Callback function de WorkManager dans la class myWorker(appContext: Context, workerParams: WorkerParameters)

    override fun doWork(): Result {

        Log.d(WorkerManager, "Début de Traitement en arriére-plan..")

        return try {
            Log.d(WorkerManager, "Bonjour depuis WorkManager !")
            Result.success()
        } catch (e: Exception) {
            Log.d(WorkerManager, "Erreur : [${e.message}]")
            Result.failure()
        }

    }

}
