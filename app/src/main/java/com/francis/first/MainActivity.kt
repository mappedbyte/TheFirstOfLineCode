package com.francis.first

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.francis.first.ActivityLifeCycleTest.MainActivity
import com.francis.first.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    //所有定义在companion
    //object中的方法都可以使用类似于Java静态方法的形式调用
    //方便别人跳转到 MainActivity  因为制定了方法和参数
    companion object{
        fun actionStart(context: Context,data1:String){
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("param1",data1)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            //显示跳转到activity
            /*    val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)*/
            /*
                 //自定义隐式跳转到自己的页面
                 val intent= Intent("com.francis.first.ACTION_START")
                     intent.addCategory("com.francis.first.MY_CATEGORY")*/


//            注意我添加了ThirdActivity  也会响应Intent.ACTION_VIEW  action  不会直接弹窗到浏览器
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")


            //跳转到拨号页面并且输入电话号码 10086
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")

            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", "hello SecondActivity")


            startActivityForResult(intent, 1)
//            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
                .show()

        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if (resultCode== RESULT_OK){
                val stringExtra = data?.getStringExtra("data_return")
                Log.d("MainActivity", "onActivityResult: $stringExtra")
            }
        }


    }

}