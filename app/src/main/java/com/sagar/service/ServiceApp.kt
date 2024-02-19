package com.sagar.service

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class ServiceApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val notificationChannel = NotificationChannel(
            Constant.NOTIFICATION_CHANNEL_ID,
            Constant.NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH
        )

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(notificationChannel)
    }
}