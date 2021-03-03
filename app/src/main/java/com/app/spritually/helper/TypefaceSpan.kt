package com.app.spritually.helper

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.TypefaceSpan

// Helper Source - https://bit.ly/2knrZy3 - Converted to Kotlin
// For any custom fonts or use not accessible from TextView, ie. ActionBar
class TypefaceSpan(family: String, private val typeFace: Typeface) :
    TypefaceSpan(family) {

    override fun updateDrawState(ds: TextPaint) {
        applyTypeFace(ds, typeFace)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyTypeFace(paint, typeFace)
    }

    private fun applyTypeFace(paint: Paint, tf: Typeface) {
        val oldStyle: Int
        val old = paint.typeface
        if (old == null) {
            oldStyle = 0
        } else {
            oldStyle = old.style
        }

        val fake = oldStyle and tf.style.inv()
        if (fake and Typeface.BOLD != 0) {
            paint.isFakeBoldText = true
        }

        if (fake and Typeface.ITALIC != 0) {
            paint.textSkewX = -0.25f
        }

        paint.typeface = tf
    }
}