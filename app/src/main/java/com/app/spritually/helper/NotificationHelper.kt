package com.abcmcoe.trackpad.helpers

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

import androidx.core.app.NotificationCompat

import com.app.spritually.R
import com.app.spritually.ui.activity.MainActivity

@Deprecated("Not usable in this project. Will not use push notifications")
class NotificationHelper(private val context: Context) {
    private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val helloNotification: Notification
    private val goodbyeNotification: Notification
    private val customBuiltNotification: Notification? = null
    private val notificationId = 1

    init {
        this.helloNotification = buildNotification("Hello", "You're near your beacon")
        this.goodbyeNotification = buildNotification("Bye bye", "You've left the proximity of your beacon")


    }

    private fun buildNotification(title: String, text: String): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val contentChannel = NotificationChannel(
                    "content_channel", "Things near you", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(contentChannel)
        }

        return NotificationCompat.Builder(context, "content_channel")
                .setSmallIcon(R.drawable.notification_tile_bg)
                .setContentTitle(title)
                .setContentText(text)
                .setContentIntent(PendingIntent.getActivity(context, 0,
                        Intent(context, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()
    }

    fun notificationHelperBuilder(title: String, message: String) {
        NotificationCompat.Builder(context, "content_channel")
                .setSmallIcon(R.drawable.notification_tile_bg)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(PendingIntent.getActivity(context, 0,
                        Intent(context, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()
    }

}
