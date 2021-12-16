package com.github.jhamin0511.launchscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val pref = AppPreferences.getInstance(this)
        findViewById<Button>(R.id.logout).setOnClickListener {
            pref.sign = false
            startActivity(SignActivity.start(this))
        }
    }

}
