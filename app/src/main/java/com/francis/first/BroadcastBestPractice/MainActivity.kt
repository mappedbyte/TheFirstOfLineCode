package com.francis.first.BroadcastBestPractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.francis.first.ActivityLifeCycleTest.BaseActivity
import com.francis.first.R
import com.francis.first.databinding.ActivityMain8Binding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMain8Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main8)
        //
        binding = ActivityMain8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.forceOffline.setOnClickListener {
            val intent = Intent("com.francis.first.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }
}