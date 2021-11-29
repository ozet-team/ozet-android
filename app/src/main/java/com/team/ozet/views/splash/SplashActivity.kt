package com.team.ozet.views.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.team.ozet.R
import com.team.ozet.base.BaseActivity
import com.team.ozet.databinding.ActivitySplashBinding
import com.team.ozet.views.main.MainActivity


class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        move()

    }



    fun move(){
        Handler(Looper.getMainLooper()).postDelayed({
//            intent = Intent(this, MainActivity::class.java)
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, DURATION)
    }

    companion object {
        private const val DURATION : Long = 2000
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }




}