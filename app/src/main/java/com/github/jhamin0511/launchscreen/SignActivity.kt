package com.github.jhamin0511.launchscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context): Intent {
            return Intent(context, SignActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign)

        val pref = AppPreferences.getInstance(this)
        findViewById<Button>(R.id.sign).setOnClickListener {
            pref.sign = true
            startActivity(MainActivity.start(this))
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}
