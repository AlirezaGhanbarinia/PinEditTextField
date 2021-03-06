package com.poovam.pinedittextfield

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

/**
 * Created by poovam-5255 on 5/23/2018.
 * Normal pin field with bottom lines
 */

class LinePinField : PinField {

    constructor(context: Context): super(context)

    constructor(context: Context, attr: AttributeSet) : super(context,attr)

    constructor(context: Context, attr: AttributeSet, defStyle: Int) : super(context,attr,defStyle)

    override fun onDraw(canvas: Canvas?) {

        for (i in 0 until numberOfFields){

            val x1 = (i*singleFieldWidth)
            val padding = (if (distanceInBetween!= defDistanceInBetweenValue) distanceInBetween else getDefaultDistanceInBetween())/2
            val paddedX1 = (x1 + padding)
            val paddedX2 = ((x1+singleFieldWidth)-padding)
            val paddedY1 = height - yPadding
            val textX = ((paddedX2-paddedX1)/2)+paddedX1
            val textY = (paddedY1- lineThickness)-(textPaint.textSize/4)
            val character:Char? = text?.getOrNull(i)

            if(isHighlightEnabled && hasFocus()){
                canvas?.drawLine(paddedX1,paddedY1,paddedX2,paddedY1, highlightPaint)
            }else{
                canvas?.drawLine(paddedX1,paddedY1,paddedX2,paddedY1, fieldPaint)
            }

            if(character!=null) {
                canvas?.drawText(character.toString(),textX,textY, textPaint)
            }

        }

    }
}