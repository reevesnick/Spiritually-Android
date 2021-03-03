package com.app.spritually.helper

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView

/**
 * For the EditText and the TextView to show visibility when EditText has value.
 * Example: If a Text field, such as a purchase Order is written, it will display the TextView to
 * indicate a field. Usually in an empty field. It will show a gray Text Field Hint.
 *
 * @param mEditText EditText widget variable
 * @param mTextView TextView widget variable
 */

class AddChangeTextWatcher(var mEditText: EditText, var mTextView: TextView) : TextWatcher {
    var context: Context? = null
    override fun beforeTextChanged(
        s: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ) { /*Abstract Method Empty*/
    }

    override fun onTextChanged(
        s: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        if (s.toString() == "") {
            mTextView.visibility = View.INVISIBLE
        } else mTextView.visibility = View.VISIBLE
    }

    override fun afterTextChanged(s: Editable) { /*Abstract Method Empty*/
    }

}