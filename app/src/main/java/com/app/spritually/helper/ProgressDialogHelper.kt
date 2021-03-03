package com.app.spritually.helper

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context

class ProgressDialogHelper {
    internal var mProgressDialog: ProgressDialog? = null

    //make sure the previous dialog is hidden
    var progressDialog: ProgressDialog?
        get() = mProgressDialog
        set(mProgressDialog) {
            hide()
            this.mProgressDialog = mProgressDialog
        }

    constructor()

    constructor(context: Activity) {
        mProgressDialog = ProgressDialog(context)
        mProgressDialog!!.setTitle("Please wait")
        mProgressDialog!!.setMessage("Loading")
        mProgressDialog!!.setCancelable(true)
        mProgressDialog!!.isIndeterminate = true
    }

    constructor(context: Context, title: String, message: String) {
        mProgressDialog = ProgressDialog(context)
        mProgressDialog!!.setTitle(title)
        mProgressDialog!!.setMessage(message)
        mProgressDialog!!.show()
    }

    fun show() {
        if (mProgressDialog != null && !mProgressDialog!!.isShowing) {
            mProgressDialog!!.show()
        }
    }

    fun create(context: Context, title: String, message: String) {
        if (mProgressDialog != null) {
            mProgressDialog!!.dismiss()
        }
        mProgressDialog = ProgressDialog.show(context, title, message)
    }

    fun hide() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
            mProgressDialog = null
        }
    }

    fun dismiss() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog = null
        }
    }

    fun onDestroy() {
        hide()
    }
}
