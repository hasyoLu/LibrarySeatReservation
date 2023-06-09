package com.example.libraryseatreservation.base


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.ParameterizedType

/**
 * BaseActivity
 * 别的Activity继承于此
 */
open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Toasty：显示错误Toast
     */
    fun showErrorToast(
        context: Context,
        msg: String,
        withIcon: Boolean = true,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        // Toasty.error(context, msg, duration, withIcon).show()
        Toast.makeText(context, msg, duration).show()
    }

    /**
     * Toasty：显示成功Toast
     */
    fun showSuccessToast(
        context: Context,
        msg: String,
        withIcon: Boolean = true,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        // Toasty.success(context, msg, duration, withIcon).show()
        Toast.makeText(context, msg, duration).show()
    }

    /**
     * Toasty：显示信息Toast
     */
    fun showInfoToast(
        context: Context,
        msg: String,
        withIcon: Boolean = true,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        // Toasty.info(context, msg, duration, withIcon).show()
        Toast.makeText(context, msg, duration).show()
    }

    /**
     * Toasty：显示警告Toast
     */
    fun showWarningToast(
        context: Context,
        msg: String,
        withIcon: Boolean = true,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        // Toasty.warning(context, msg, duration, withIcon).show()
        Toast.makeText(context, msg, duration).show()
    }
    /*
     * 通过AndPermission请求权限
    fun requestPermission(
        context: Context,
        vararg permissions: String,
        granted: Action<List<String>>,
        denied: Action<List<String>>
    ) {
        AndPermission.with(context)
            .runtime()
            .permission(permissions)
            .onGranted(granted) // 权限被允许
            .onDenied(denied) // 权限被拒绝
            .start()
    }

     */
}