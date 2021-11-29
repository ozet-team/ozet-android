package com.team.ozet.view.login

import android.os.Bundle
import com.team.ozet.R
import com.team.ozet.base.BaseActivity
import com.team.ozet.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_login) {
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelCallback()
    }

    private fun initViewModelCallback(){
        with(viewModel){

        }
    }
}