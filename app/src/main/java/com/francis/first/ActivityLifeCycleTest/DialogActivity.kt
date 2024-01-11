package com.francis.first.ActivityLifeCycleTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.francis.first.R

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }
}