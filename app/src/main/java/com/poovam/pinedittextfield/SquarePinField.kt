package com.poovam.pinedittextfield

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

/**
 * Created by poovam-5255 on 5/23/2018.
 *
 * Pin field represented with squares
 */

class SquarePinField : PinField{

    constructor(context: Context): super(context)

    constructor(context: Context, attr: AttributeSet) : super(context,attr)

    constructor(context: Context, attr: AttributeSet, defStyle: Int) : super(context,attr,defStyle)


    override fun onDraw(canvas: Canvas?) {

        for (i in 0 until numberOfFields){

            val x1 = (i*singleFieldWidth)
            val padding = (if (distanceInBetween!= defDistanceInBetweenValue) distanceInBetween else getDefaultDistanceInBetween())/2
            val paddedX1 = (x1 + padding)
            val paddedX2 = ((x1+singleFieldWidth)-padding)
            val squareHeight = paddedX2-paddedX1
            val paddedY1 = (height/2)-(squareHeight/2)
            val paddedY2 = (height/2)+(squareHeight/2)
            val textX = ((paddedX2-paddedX1)/2)+paddedX1
            val textY = ((paddedY2-paddedY1)/2+paddedY1)+ lineThickness +(textPaint.textSize/4)
            val character:Char? = text?.getOrNull(i)

            if(isHighlightEnabled && hasFocus()){
                canvas?.drawRect(paddedX1,paddedY1,paddedX2,paddedY2, highlightPaint)
            }else{
                canvas?.drawRect(paddedX1,paddedY1,paddedX2,paddedY2, fieldPaint)
            }

            if(character!=null) {
                canvas?.drawText(character.toString(),textX,textY, textPaint)
            }
        }
    }
}