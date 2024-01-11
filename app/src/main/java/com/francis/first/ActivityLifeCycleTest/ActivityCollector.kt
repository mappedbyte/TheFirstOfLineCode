package com.francis.first.ActivityLifeCycleTest

import android.app.Activity

object ActivityCollector {
    private val activities=ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun  removeActivity(activity: Activity){
        activities.remove(activity)
    }

    //从此以后，不管你想在什么地方退出程序，只需要调用ActivityCollector.finishAll()
    //方法就可以了
    fun finishAll(){
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish() // 结束指定的Activity
            }
        }
        activities.clear()
    }

}