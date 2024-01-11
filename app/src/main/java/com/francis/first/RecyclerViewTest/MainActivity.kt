package com.francis.first.RecyclerViewTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.francis.first.ListViewTest.Fruit
import com.francis.first.R
import com.francis.first.databinding.ActivityMain4Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding

    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main4)
        initFruits()
        binding= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter=FruitAdapter(fruitList)
//        val layoutManager = LinearLayoutManager(this)
        //横向排列
//        layoutManager.orientation=LinearLayoutManager.HORIZONTAL

        //瀑布流
        val layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)


        //LayoutManager用于指定RecyclerView的布局方式，这里使用的
        //LinearLayoutManager是线性布局的意思
        binding.recyclerView.layoutManager=layoutManager

    }

  /*  private fun initFruits(){
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
*/

    //瀑布流
    private fun initFruits(){
        //repeat函数是Kotlin中另外一个非常常用的标准函数，它允许你
        //传入一个数值n，然后会把Lambda表达式中的内容执行n遍
        repeat(2){
            fruitList.add(Fruit(getRandomLengthString("Apple"),
                R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Banana"),
                R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange"),
                R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelon"),
                R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear"),
                R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape"),
                R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"),
                R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Strawberry"),
                R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry"),
                R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango"),
                R.drawable.mango_pic))

        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}