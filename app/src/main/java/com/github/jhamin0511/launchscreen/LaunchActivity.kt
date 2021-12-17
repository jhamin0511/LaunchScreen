package com.github.jhamin0511.launchscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pref = AppPreferences.getInstance(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (!pref.sign) {
                startActivity(SignActivity.start(this))
            } else {
                startActivity(MainActivity.start(this))
            }
            overridePendingTransition(0, R.anim.transition_launch_finish)
        }, TimeUnit.SECONDS.toMillis(1))
    }

}
