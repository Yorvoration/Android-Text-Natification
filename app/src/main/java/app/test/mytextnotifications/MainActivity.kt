package app.test.mytextnotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private val Channel_id = "Astrum Students"
    private val notificationID = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_button = findViewById<Button>(R.id.btn_button)

        createNotificationChannel()

        btn_button.setOnClickListener{
            sendNotification()
        }

    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification Title"
            val descriptionText = "Notification description"
            val importance: Int =NotificationManager.IMPORTANCE_DEFAULT
            val channel: NotificationChannel = NotificationChannel(Channel_id, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val builder = NotificationCompat.Builder(this, Channel_id)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Asadbek Doimjonov")
            .setContentText("2004.10.02")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        with(NotificationManagerCompat.from(this)){
            notify(notificationID, builder.build())
        }
    }

}