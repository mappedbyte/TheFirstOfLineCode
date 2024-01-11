package com.francis.first.ListViewTest

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.francis.first.R

class FruitAdapter(activity: Activity, private val resId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resId, data) {


    inner class ViewHolder(val fruitImageView: ImageView, val fruitName: TextView)

    //性能问题   val view = LayoutInflater.from(context).inflate(resId, parent, false)
    //每次都会区加载一次布局文件
    //convertView 会缓存上一次的布局
    //并且我们还会每次都findViewById 获取控件
    //所以我们可以重写getView方法
    //重写getView方法的时候，我们首先会判断convertView是否为空，不为空则表示可以重用，直接对convertView进行操作
    //为空则表示需要重新加载布局文件，然后对布局文件进行缓存
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /* val view = LayoutInflater.from(context).inflate(resId, parent, false)
         val fruitImage = view.findViewById<ImageView>(R.id.fruitImage)
         val fruitName = view.findViewById<TextView>(R.id.fruitName)
         val fruit = getItem(position)
         if (fruit != null) {
             fruitImage.setImageResource(fruit.imageId)
             fruitName.text=fruit.name
         }

         return view*/
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder=ViewHolder(fruitImage,fruitName)
            view.tag=viewHolder
        }else{
            view=convertView
            viewHolder=view.tag as ViewHolder
        }
        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImageView.setImageResource(fruit.imageId)
            viewHolder.fruitName.text=fruit.name
        }
        return view
    }


}