package com.openci.ui.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.openci.common.Constants.CALLBACK_URL
import com.openci.common.Constants.OAUTH_URL
import com.openci.common.Constants.PREFS_NAME
import com.openci.databinding.ActivityLoginBinding
import com.openci.models.GitHubConfigHelper.getClientID
import com.openci.ui.base.BaseActivity
import com.openci.utils.viewModelOf


class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences =
            getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val public_travis_token =
            sharedPreferences.getString("public_travis_token", null)
        val private_travis_token =
            sharedPreferences.getString("private_travis_token", null)

//        if (public_travis_token != null && private_travis_token != null) {
//            val intentToMainActivity = Intent(this@LoginActivity, MainActivity::class.java)
//            startActivity(intentToMainActivity)
//            finish()
//        }

        setContentView(mViewBinding.root)
        val url = OAUTH_URL + "?client_id=" + getClientID() + "&scope=repo&redirect_uri=" + CALLBACK_URL;
        mViewBinding.btnLogin.setOnClickListener { attemptLogin(url) }
    }

    private fun attemptLogin(url: String) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(i)
        finish()
    }

    override fun getViewBinding(): ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)

    override fun getViewModel() = viewModelOf<LoginViewModel>(mViewModelProvider)
}
