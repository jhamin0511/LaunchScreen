package com.github.jhamin0511.launchscreen

import android.content.Context

private const val FILE_NAME = "app_prefs.xml"
private const val SIGN = "sign"

class AppPreferences(
    context: Context
) {

    companion object {
        @Volatile
        private var instance: AppPreferences? = null

        @JvmStatic
        fun getInstance(context: Context): AppPreferences =
            instance ?: synchronized(this) {
                instance ?: AppPreferences(context).also {
                    instance = it
                }
            }
    }

    private val pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    var sign: Boolean
        get() = pref.getBoolean(SIGN, false)
        set(value) = pref.edit().putBoolean(SIGN, value).apply()

}
