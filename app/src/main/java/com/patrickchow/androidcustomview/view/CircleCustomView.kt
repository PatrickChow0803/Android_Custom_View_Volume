package com.patrickchow.androidcustomview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class CircleCustomView (context: Context?, attrs: AttributeSet?): View(context, attrs){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas?) {

        //Draw a black circle in the middle of the screen
        paint.color = Color.BLACK
        canvas?.drawCircle(width/2.0f, height/2.0f, 500f, paint)

        //Create the white outline inside of the black circle
        val p = Paint()
        p.style = Paint.Style.STROKE
        p.color = Color.WHITE

        canvas?.drawCircle(width/2.0f, height/2.0f, 450f, p)

        //Create the red circle that's used to adjust the volume
        paint.color = Color.RED
        canvas?.drawCircle(width/3.5f, height/1.5f, 30f, paint)

        canvas?.rotate(100f)

        super.onDraw(canvas)
    }
}