package com.francis.first.NotificationTest

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.francis.first.R
import com.francis.first.databinding.ActivityMain11Binding

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMain11Binding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main11)
        binding = ActivityMain11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    /*        val notificationChannel =
                NotificationChannel("normal", "消息通知", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(notificationChannel)*/
            val channel2 = NotificationChannel("important", "Important",
                NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }


        //对希望访问通知策略的应用程序的标记权限。
        //防护等级:正常Manifest.permission.ACCESS_NOTIFICATION_POLICY
        ActivityCompat.requestPermissions(this,  arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0);

        val intent = Intent(this, NotificationActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)
        //setStyle()方法，这个方法允许我们构建出富文本的通知内容。也就是说，通知中
        //不光可以有文字和图标，还可以包含更多的东西
        binding.sendNotice.setOnClickListener {




//            val notification = NotificationCompat.Builder(this, "normal")
            val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("消息通知")
//                .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data,  and use voice actions.Get the official Android IDE and developer tools to build apps for Android."))
                .setContentText("Learn how to build notifications, send and sync data,\n" +
                        " and use voice actions.Get the official Android IDE and developer tools to\n" +
                        " build apps for Android.")
                .setSmallIcon(R.drawable.pineapple_pic)
//                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(
//                    BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.apple_pic))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()
            notification.iconLevel=10000

            manager.notify(1,notification)
        }




    }
}