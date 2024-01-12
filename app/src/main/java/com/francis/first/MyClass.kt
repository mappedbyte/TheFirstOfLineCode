package com.francis.first

import Later

class MyClass {
    //这种写法就代表着将p属性的具体实现委托给了Delegate类去完成。当调用p属性的时候会自
//动调用Delegate类的getValue()方法，当给p属性赋值的时候会自动调用Delegate类的
//setValue()方法。
    val p by Later {

    }
}