package com.example.libraryseatreservation.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import com.example.libraryseatreservation.R
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

class ResultBean(var row: String? = null,var seat: String? = null, var status: Int = 0) {
    /**
     * row : 1
     * seat : 1
     * status : 2
     */
    var left = 0
    var top = 0
    var right = 0
    var bottom = 0
    var context: Context? = null
    var isIst = false
        private set

    fun setIst(ist: Boolean) {
        isIst = ist
    }

    fun draw(canvas: Canvas, context: Context) {
        if (status == 2) {
            @SuppressLint("UseCompatLoadingForDrawables") val drawable =
                context.resources.getDrawable(R.drawable.xuan2) as BitmapDrawable
            val bitmap = drawable.bitmap
            val width = bitmap.width
            val height = bitmap.height
            var row = row!!.toInt()
            var seat = seat!!.toInt()
            row = row * 50
            seat = seat * 50
            canvas.drawBitmap(bitmap, seat.toFloat(), row.toFloat(), Paint())
            left = seat
            top = row
            right = seat + width
            bottom = row + height
        }
        if (status == 1) {
            @SuppressLint("UseCompatLoadingForDrawables") val drawable =
                context.resources.getDrawable(R.drawable.xuan1) as BitmapDrawable
            val bitmap = drawable.bitmap
            val width = bitmap.width
            val height = bitmap.height
            var row = row!!.toInt()
            var seat = seat!!.toInt()
            row = row * 50
            seat = seat * 50
            canvas.drawBitmap(bitmap, seat.toFloat(), row.toFloat(), Paint())
            left = seat
            top = row
            right = seat + width
            bottom = row + height
        }
        if (status == 3) {
            @SuppressLint("UseCompatLoadingForDrawables") val drawable =
                context.resources.getDrawable(R.drawable.xuan3) as BitmapDrawable
            val bitmap = drawable.bitmap
            val width = bitmap.width
            val height = bitmap.height
            var row = row!!.toInt()
            var seat = seat!!.toInt()
            row = row * 50
            seat = seat * 50
            canvas.drawBitmap(bitmap, seat.toFloat(), row.toFloat(), Paint())
            left = seat
            top = row
            right = seat + width
            bottom = row + height
        }
    }
}