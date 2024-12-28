package com.task.sm.onesignal

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIDService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        println(">>>>>>>>>>>>>>>>>>>> Refreshed token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        println(">>>>>>>>>>>>>>>>>>>> Remote Message from: ${message.from}")

        if (message.data.isNotEmpty()){
            println(">>>>>>>>>>>>>>>>>>>>>>>>> Message data paylaod: ${message.data}")
        }
    }
}