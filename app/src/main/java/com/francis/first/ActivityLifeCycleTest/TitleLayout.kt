package com.francis.first.ActivityLifeCycleTest

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

class TitleLayout(context: Context,attributeSet: AttributeSet):LinearLayout(context,attributeSet) {
    init {
        //标题栏
//        LayoutInflater.from(context).inflate(R.layout.title,this)
        //对标题栏的返回按钮做activity 销毁 因为这个是公用的
    }


}