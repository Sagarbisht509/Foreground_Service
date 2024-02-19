package com.sagar.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class DownloadService : Service() {

    // IBinder -> used to create bound service (one active instance, multiple components can connect that one instance)
    override fun onBind(p0: Intent?): IBinder? {
        return null // nothing bind
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when (intent?.action) {
            Actions.START.toString() -> start()

            Actions.STOP.toString() -> stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, Constant.NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_download)
            .setContentTitle("Downloading")
            .setContentText("downloaded percentage 66/100")
            .build()

        startForeground(1, notification)
    }

    enum class Actions {
        START,
        STOP
    }
}