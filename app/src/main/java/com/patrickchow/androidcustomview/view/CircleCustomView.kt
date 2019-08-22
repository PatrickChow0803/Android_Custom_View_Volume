package com.patrickchow.androidcustomview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.patrickchow.androidcustomview.MainActivity


class CircleCustomView (context: Context?, attrs: AttributeSet?): View(context, attrs){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var toast = Toast(context)

    var canvasRotation = rotation
    
    private var xStart: Float = 0f
    private var yStart: Float = 0f
    private var xDiff: Float = 0f
    private var yDiff: Float = 0f
    var volume = 0


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            //Is called when the user pushes on the view
            MotionEvent.ACTION_DOWN -> {
                Log.i("hello", "world")
                xStart = event.x
            }
            //Is called when the user drags their finger across
            MotionEvent.ACTION_MOVE ->{
                Log.i("You Moved", "world")
                xDiff = event.x - xStart
                rotation = canvasRotation + xDiff/10
            }
            //Is called when the user lifts up their finger

            MotionEvent.ACTION_UP ->{
                volume = (rotation/360*100).toInt()
                Log.i("Goodbye", "world")
                toast = Toast.makeText(context, "Volume Level is: $volume", Toast.LENGTH_SHORT)
                toast.show()
                canvasRotation = rotation
            }

        }

        return true
    }

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