package com.francis.first.BroadcastTest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.francis.first.R
import com.francis.first.databinding.ActivityMain7Binding

class MainActivity : AppCompatActivity() {

    private lateinit var timerChangeReceiver: TimerChangeReceiver

    private lateinit var binding: ActivityMain7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main7)
            binding= ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timerChangeReceiver=TimerChangeReceiver()
        registerReceiver(timerChangeReceiver, intentFilter)

        binding.button.setOnClickListener {
            val intent = Intent("com.francis.first.MY_BROADCAST")
            //在Android
            //8.0系统之后，静态注册的BroadcastReceiver是无法接收隐式广播的，而默认情况下我们发出
            //的自定义广播恰恰都是隐式广播。因此这里一定要调用setPackage()方法，指定这条广播是
            //发送给哪个应用程序的，从而让它变成一条显式广播，否则静态注册的BroadcastReceiver将
            //无法接收到这条广播。
            intent.setPackage(packageName)
//            sendBroadcast(intent)
            //有序广播 可以截断  第二个参数是权限相关字符串
            sendOrderedBroadcast(intent,null)

        }



    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timerChangeReceiver)
    }


    inner class TimerChangeReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"Time has changed",Toast.LENGTH_SHORT).show()
        }

    }
}

