package com.abcmcoe.trackpad.helpers

import android.content.Context
import android.widget.Toast

object ToastMessageHelper {

    /**
     * Creates a Toast.
     *
     * @param context The context.
     * @param isLong Whether the Toast should have a Toast.LENGTH_LONG or Toast.LENGTH_SHORT.
     * @param text The text to display in the Toast.
     */
    fun make(context: Context, isLong: Boolean, text: String) {
        val duration = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT

        Toast.makeText(context, text, duration).show()
    }

    /**
     * Creates a Toast with duration = Toast.LENGTH_LONG.
     *
     * @param context The context.
     * @param text The text to display in the Toast.
     */
    fun make(context: Context, text: String) {
        make(context, true, text)
    }
}
