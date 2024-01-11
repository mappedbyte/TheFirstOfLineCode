package com.francis.first.ListViewTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.francis.first.R
import com.francis.first.databinding.ActivityMain3Binding

class MainActivity : AppCompatActivity() {

    private val data = listOf("Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
        "Pineapple", "Strawberry", "Cherry", "Mango")

    private val fruitList = ArrayList<Fruit>()

    private lateinit var binding:ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main3)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        val adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, R.id.tv_name,data)
//        binding.listView.adapter = adapter

        initFruits()
        val fruitAdapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        binding.listView.adapter=fruitAdapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()

        }

    }



    private fun initFruits(){
        //repeat函数是Kotlin中另外一个非常常用的标准函数，它允许你
        //传入一个数值n，然后会把Lambda表达式中的内容执行n遍
        repeat(2){
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))

        }
    }
}