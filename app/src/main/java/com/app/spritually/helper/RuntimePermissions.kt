package com.app.spritually.helper

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class RuntimePermissions(private val permissions: Array<String>?, private val mContext: Context?) {

    init {
        val PERMISSION_ALL = 1
        if (!hasPermissions()) {
            permissions?.let { ActivityCompat.requestPermissions((mContext as Activity?)!!, it, PERMISSION_ALL) }
        }
    }

    fun hasPermissions(): Boolean {
        if (mContext != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(mContext, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }
}