package com.app.spritually.helper

import android.R
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


object SnackbarHelper {
    private lateinit var mSnackBar: Snackbar // Global Field

    /**
     * For this particular SnackBar, the offline notification will be on to top, cannot translate into a
     * Builder statement.
     * @param rootView - Define the rootView from Activity.
     */

    fun networkOfflineSnackbar(rootView: View) {
        mSnackBar =  Snackbar.make(rootView.findViewById(R.id.content), "No Internet Connectivity", Snackbar.LENGTH_INDEFINITE)
        val view = mSnackBar.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        val tv = view.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
        params.gravity = Gravity.TOP
        params.setMargins(0,0,0,0)
        mSnackBar.setBackgroundTint(Color.RED)
        mSnackBar.setTextColor(Color.WHITE)
        tv.textAlignment = View.TEXT_ALIGNMENT_CENTER
        tv.gravity = Gravity.CENTER_VERTICAL
        view.layoutParams = params
        mSnackBar.show()
    }

    /**
     * Snackbar will need a initializer, otherwise it will crash.
     * Best way to do this is to hide the snackbar when connection is established.
     * It will dismiss the offline snackbar
     * @param rootView - Define the rootView from Activity.
     */
    fun networkOnlineSnackbar(rootView: View) {
        mSnackBar =  Snackbar.make(rootView.findViewById(R.id.content), "", 1)
        val view = mSnackBar.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.setMargins(0,0,0,0)
        params.height = 0
        view.layoutParams = params

        mSnackBar.show()
    }




}
