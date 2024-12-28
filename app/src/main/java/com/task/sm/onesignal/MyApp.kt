package com.task.sm.onesignal

import android.app.Application
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessagingService
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyApp : Application() {

    companion object {
        var firebaseApp: MutableLiveData<FirebaseApp>? = null
    }

    private var firebaseInitialized = false
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
        firebaseInitialized = true
        initializeOneSignal()
    }

    private fun initializeOneSignal() {
        // Verbose Logging set to help debug issues, remove before releasing your app.
        OneSignal.Debug.logLevel = LogLevel.VERBOSE

        // OneSignal Initialization
        OneSignal.initWithContext(this, "8fdb5160-225f-4f3c-80cc-ce5725972b15")

        // requestPermission will show the native Android notification permission prompt.
        // NOTE: It's recommended to use a OneSignal In-App Message to prompt instead.
        CoroutineScope(Dispatchers.IO).launch {
            OneSignal.Notifications.requestPermission(false)
        }
    }
}