package com.example.notificationapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    //variables
    val CHANNEL_ID = "firstId"
    val CHANNEL_NAME = "firstName"
    val NOTIFICATION_ID = 0
    lateinit var button:Button

    //functions
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        val notification = NotificationCompat.Builder( this, CHANNEL_ID)
            .setContentTitle("Displaying the first notification")
            .setContentText("This is the Content Text")
            .setCategory("App by s_b")
            .setSmallIcon(R.drawable.notif_icon)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)

        button = findViewById(R.id.button)
        //button action
        button.setOnClickListener{
            notificationManager.notify(NOTIFICATION_ID, notification)
        }


        //Transparent Status Bar
        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )
    }

        //NOTIFICATIONS
        //notif. channel
        fun createNotificationChannel(){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    CHANNEL_ID, CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
                ).apply {
                    //modifications of how your notif appears
                }
                //notif. manager
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            } }

}