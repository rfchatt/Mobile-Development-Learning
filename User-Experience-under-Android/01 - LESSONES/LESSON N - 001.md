# WorkManager pour les débutants 🎯

## C'est quoi WorkManager ?
C'est un **robot qui fait des tâches pour toi même quand ton app est fermée**.

---

## 🔧 Les 3 étapes simples

### Étape 1️⃣ : Créer ton robot (Worker)
```kotlin
class MonRobot(context: Context, params: WorkerParameters) 
    : Worker(context, params) {
    
    override fun doWork(): Result {
        // ✅ Fais ton travail ici
        println("Je sauvegarde les données...")
        
        // ✅ Dis si c'est réussi
        return Result.success()
        
        // ❌ Ou si ça a échoué
        // return Result.failure()
        
        // 🔄 Ou pour réessayer plus tard
        // return Result.retry()
    }
}
```

### Étape 2️⃣ : Donner des instructions au robot
```kotlin
// 🚀 Pour une tâche UNE SEULE FOIS
val uneFois = OneTimeWorkRequestBuilder<MonRobot>()
    .build()

// 🔁 Pour une tâche RÉPÉTÉE (minimum 15 minutes)
val repetee = PeriodicWorkRequestBuilder<MonRobot>(
    15, TimeUnit.MINUTES  // Toutes les 15 minutes
).build()
```

### Étape 3️⃣ : Lancer le robot
```kotlin
WorkManager.getInstance(context).enqueue(uneFois)
```

---

## 📋 Exemples concrets

### Exemple 1 : Sauvegarder des données UNE fois
```kotlin
// Mon robot
class SauvegardeRobot(context: Context, params: WorkerParameters) 
    : Worker(context, params) {
    
    override fun doWork(): Result {
        // Sauvegarder dans la base de données
        database.save("Mes données")
        return Result.success()
    }
}

// Lancer le robot
val travail = OneTimeWorkRequestBuilder<SauvegardeRobot>().build()
WorkManager.getInstance(context).enqueue(travail)
```

### Exemple 2 : Envoyer des données TOUTES LES HEURES
```kotlin
class EnvoiRobot(context: Context, params: WorkerParameters) 
    : Worker(context, params) {
    
    override fun doWork(): Result {
        // Envoyer au serveur
        api.sendData()
        return Result.success()
    }
}

// Lancer toutes les heures
val travail = PeriodicWorkRequestBuilder<EnvoiRobot>(
    1, TimeUnit.HOURS
).build()

WorkManager.getInstance(context).enqueue(travail)
```

---

## 🎛️ Les Constraints (Conditions)

Tu peux dire au robot : **"Travaille SEULEMENT si..."**

```kotlin
val conditions = Constraints.Builder()
    .setRequiredNetworkType(NetworkType.CONNECTED)  // ✅ Internet connecté
    .setRequiresCharging(true)                      // ✅ En charge
    .setRequiresBatteryNotLow(true)                 // ✅ Batterie OK
    .build()

val travail = OneTimeWorkRequestBuilder<MonRobot>()
    .setConstraints(conditions)  // ⚠️ Ajoute les conditions
    .build()

WorkManager.getInstance(context).enqueue(travail)
```

---

## 📊 Tableau récapitulatif

| Quoi | Quand l'utiliser | Code |
|------|------------------|------|
| **OneTimeWorkRequest** | Faire une fois | `OneTimeWorkRequestBuilder<MonRobot>()` |
| **PeriodicWorkRequest** | Répéter (15min minimum) | `PeriodicWorkRequestBuilder<MonRobot>(15, TimeUnit.MINUTES)` |
| **Constraints** | Ajouter des conditions | `.setConstraints(...)` |
| **doWork()** | Le code à exécuter | `override fun doWork()` |

---

## 🎯 Cas d'utilisation simples

### ✅ Utilise WorkManager pour :
- 📤 **Envoyer** une photo au serveur
- 💾 **Sauvegarder** des données importantes
- 🔄 **Synchroniser** avec le cloud
- 🧹 **Nettoyer** les vieux fichiers chaque semaine

### ❌ N'utilise PAS WorkManager pour :
- 📥 **Afficher** une image (utilise Coil/Glide)
- 🎨 **Animer** un bouton
- ⚡ **Charger** des données rapidement (utilise Coroutines)

---

## 🎁 Template complet prêt à l'emploi

```kotlin
// 1. Créer le robot
class UploadPhotoRobot(context: Context, params: WorkerParameters) 
    : Worker(context, params) {
    
    override fun doWork(): Result {
        return try {
            // Ton code ici
            uploadPhoto()
            Result.success() // ✅
        } catch (e: Exception) {
            Result.retry() // 🔄
        }
    }
}

// 2. Configurer et lancer
val conditions = Constraints.Builder()
    .setRequiredNetworkType(NetworkType.CONNECTED)
    .build()

val travail = OneTimeWorkRequestBuilder<UploadPhotoRobot>()
    .setConstraints(conditions)
    .build()

WorkManager.getInstance(context).enqueue(travail)
```

---

## 📦 Installation

Ajoute dans ton `build.gradle.kts` (Module: app) :

```kotlin
dependencies {
    implementation("androidx.work:work-runtime-ktx:2.9.0")
}
```

---

## 🚀 Démarrage rapide

1. Crée ta classe Worker
2. Configure ton WorkRequest
3. Lance avec `enqueue()`
4. C'est tout ! 🎉

---

## 📚 Ressources

- [Documentation officielle](https://developer.android.com/topic/libraries/architecture/workmanager)
- [Codelab WorkManager](https://developer.android.com/codelabs/android-workmanager)

---

**Fait avec ❤️ pour les débutants en Kotlin**
