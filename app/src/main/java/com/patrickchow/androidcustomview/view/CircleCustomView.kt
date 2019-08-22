package com.patrickchow.androidcustomview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleCustomView (context: Context?, attrs: AttributeSet?): View(context, attrs){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas?) {

        //Draw a black circle in the middle of the screen
        paint.color = Color.BLACK
        canvas?.drawCircle(width/2.0f, height/2.0f, 500f, paint)

        

        super.onDraw(canvas)
    }
}