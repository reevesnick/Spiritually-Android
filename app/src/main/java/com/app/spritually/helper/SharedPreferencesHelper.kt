package com.abcmcoe.trackpad.helpers

import android.content.Context


object SharedPreferencesHelper {

    /**
     * Set a string shared preference
     * @param pref - Preference Name
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceString(context: Context, pref: String, key: String, value: String) {
        val settings = context.getSharedPreferences(pref, 0)
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * Set a integer shared preference
     * @param pref - Preference Name
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceInt(context: Context, pref: String, key: String, value: Int) {
        val settings = context.getSharedPreferences(pref, 0)
        val editor = settings.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * Set a Boolean shared preference
     * @param pref - Preference Name
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceBoolean(context: Context, pref: String, key: String, value: Boolean) {
        val settings = context.getSharedPreferences(pref, 0)
        val editor = settings.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * Get a string shared preference
     * @param pref - Preference Name
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceString(context: Context, pref: String, key: String, defValue: String): String? {
        val settings = context.getSharedPreferences(pref, 0)
        return settings.getString(key, defValue)
    }

    /**
     * Get a integer shared preference
     * @param pref - Preference Name
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceInt(context: Context, pref: String, key: String, defValue: Int): Int {
        val settings = context.getSharedPreferences(pref, 0)
        return settings.getInt(key, defValue)
    }

    /**
     * Get a boolean shared preference
     * @param pref - Preference Name
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceBoolean(context: Context, pref: String, key: String, defValue: Boolean): Boolean {
        val settings = context.getSharedPreferences(pref, 0)
        return settings.getBoolean(key, defValue)
    }

    /**
     * Clear a shared preference settings, or just use the default settings
     * @param pref - Preference Name
     * @param key - Key to look up in shared preferences.
     */
    fun clearSharedPreference(context: Context, pref: String){
        val settings = context.getSharedPreferences(pref, 0)
        val editor = settings.edit()
        editor.clear()
        editor.apply()
    }
}
