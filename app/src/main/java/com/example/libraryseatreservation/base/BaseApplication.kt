package com.example.libraryseatreservation.base

import android.app.Application
import android.content.Context
import cn.bmob.v3.Bmob

class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initBnob()
        context = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }
    private fun initBnob() {
        //第一：默认初始化
        Bmob.initialize(this, "f121550d48ca42362b714cb135a8453b")
        // 注:自v3.5.2开始，数据sdk内部缝合了统计sdk，开发者无需额外集成，传渠道参数即可，不传默认没开启数据统计功能
        //Bmob.initialize(this, "Your Application ID","bmob");
    }
    companion object{
        private lateinit var context: BaseApplication
        @JvmStatic
        fun getContext() : Context{
            return context
        }
    }

}