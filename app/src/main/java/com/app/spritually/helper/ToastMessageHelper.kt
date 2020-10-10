package com.app.spritually.helper

import android.content.Context
import android.widget.Toast
import java.security.AccessControlContext

object ToastMessageHelper{
    /* Creates a Toast
    * @param
    *
    * */
    fun make (context: Context, isLong: Boolean, text: String){
        val duration = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT

        Toast.makeText(context,text, duration)
    }

    // Creates a Toast with Duration = Toast.LENGTH_LONG
    fun make(context: Context, text: String){
        make (context, true, text)
    }
}