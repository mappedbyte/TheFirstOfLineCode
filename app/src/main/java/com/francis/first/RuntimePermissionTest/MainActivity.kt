package com.francis.first.RuntimePermissionTest

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.francis.first.R
import com.francis.first.databinding.ActivityMain8Binding
import com.francis.first.databinding.ActivityMain9Binding

class MainActivity : AppCompatActivity() {
//android 6之后的需要申请 因为拨号是危险权限
    private lateinit var binding: ActivityMain9Binding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main9)
        binding = ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.makeCall.setOnClickListener {

          if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

              requestPermissions( arrayOf(Manifest.permission.CALL_PHONE),1)
          }else{
              val intent = Intent(Intent.ACTION_CALL)
              intent.data=Uri.parse("tel:10086")
              startActivity(intent)
          }
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            1->{

                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data=Uri.parse("tel:10086")
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "you denied the permission", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}