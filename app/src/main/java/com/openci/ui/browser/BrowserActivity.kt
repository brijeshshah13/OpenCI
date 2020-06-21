package com.openci.ui.browser

import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import com.openci.common.Constants.CALLBACK_CODE
import com.openci.common.Constants.CALLBACK_URL
import com.openci.common.Constants.GITHUB_ACCESS_TOKEN
import com.openci.common.Constants.PRIVATE_TRAVIS_ACCESS_TOKEN
import com.openci.common.Constants.PUBLIC_TRAVIS_ACCESS_TOKEN
import com.openci.databinding.ActivityBrowserBinding
import com.openci.ui.base.BaseActivity
import com.openci.utils.State
import com.openci.utils.showToast
import com.openci.utils.viewModelOf
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class BrowserActivity : BaseActivity<BrowserViewModel, ActivityBrowserBinding>() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private var callbackCode: String? = null
    private var githubAccessToken: String? = null
    private var publicTravisAccessToken: String? = null
    private var privateTravisAccessToken: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        processIntent()
    }

    private fun processIntent() {
        val intentFromBrowser = intent
        if (intentFromBrowser != null) {
            val uri: Uri? = intentFromBrowser.data
            if (uri != null && uri.toString().startsWith(CALLBACK_URL)) {
                callbackCode = uri.getQueryParameter("code")

                when (val githubAuthState = mViewModel.getGithubAccessToken(callbackCode)) {
                    is State.Success -> {
                        githubAuthState.data.let {
                            githubAccessToken = githubAuthState.data.access_token
                        }
                    }
                    is State.Error -> {
                        showToast(githubAuthState.message)
                    }
                }

                when (val publicTravisAuthState = mViewModel.getPublicTravisAccessToken(githubAccessToken)) {
                    is State.Success -> {
                        publicTravisAuthState.data.let {
                            publicTravisAccessToken = publicTravisAuthState.data.access_token
                        }
                    }
                    is State.Error -> {
                        showToast(publicTravisAuthState.message)
                    }
                }

                when (val privateTravisAuthState = mViewModel.getPrivateTravisAccessToken(githubAccessToken)) {
                    is State.Success -> {
                        privateTravisAuthState.data.let {
                            privateTravisAccessToken = privateTravisAuthState.data.access_token
                        }
                    }
                    is State.Error -> {
                        showToast(privateTravisAuthState.message)
                    }
                }

                val editor = sharedPreferences.edit()
                editor.putString(CALLBACK_CODE, callbackCode)
                editor.putString(GITHUB_ACCESS_TOKEN, githubAccessToken)
                editor.putString(PUBLIC_TRAVIS_ACCESS_TOKEN, publicTravisAccessToken)
                editor.putString(PRIVATE_TRAVIS_ACCESS_TOKEN, privateTravisAccessToken)
                editor.commit()

//                val intentToMainActivity = Intent(this@BrowserActivity, MainActivity::class.java)
//                startActivity(intentToMainActivity)

//                getGithubAccessToken(code, object : IAPICallBack<TravisTokens?>() {
//                    fun onSuccess(travisTokens: TravisTokens) {
//                        public_travis_token = travisTokens.getPublicToken()
//                        private_travis_token = travisTokens.getPrivateToken()
//                        val editor = getSharedPreferences(
//                            PREFS_NAME,
//                            Context.MODE_PRIVATE
//                        ).edit()
//                        editor.putString("code", code)
//                        editor.putString("public_travis_token", public_travis_token)
//                        editor.putString("private_travis_token", private_travis_token)
//                        editor.commit()
//                        val intentToMainActivity =
//                            Intent(this@BrowserActivity, MainActivity::class.java)
//                        startActivity(intentToMainActivity)
//                    }
//
//                    fun onError(throwable: String) {}
//                })
            }
        }
    }

    override fun getViewBinding(): ActivityBrowserBinding = ActivityBrowserBinding.inflate(layoutInflater)

    override fun getViewModel() = viewModelOf<BrowserViewModel>(mViewModelProvider)
}
