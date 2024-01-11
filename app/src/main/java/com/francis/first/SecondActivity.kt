package com.francis.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.francis.first.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val stringExtra = intent.getStringExtra("extra_data")
        // 处理接收到的数据
        Log.d("SecondActivity","extra data is $stringExtra")
        binding.button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return","hello FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}