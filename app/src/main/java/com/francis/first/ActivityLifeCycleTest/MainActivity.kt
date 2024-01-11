package com.francis.first.ActivityLifeCycleTest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.francis.first.R
import com.francis.first.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val string = savedInstanceState.getString("data_key")
            Log.d("MainActivity","tempData is $string")
        }


        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        binding.startDialogActivity.setOnClickListener {

            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }

    }

    //这个方法可以保证在
//Activity被回收之前一定会被调用，因此我们可以通过这个方法来解决问题。
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "something you just typed"
        outState.putString("data_key", tempData)

    }


    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("MainActivity", "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }
}