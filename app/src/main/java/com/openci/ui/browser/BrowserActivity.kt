package com.openci.ui.browser

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.openci.common.Constants.CALLBACK_URL
import com.openci.databinding.ActivityBrowserBinding
import com.openci.ui.base.BaseActivity
import com.openci.utils.viewModelOf


class BrowserActivity : BaseActivity<BrowserViewModel, ActivityBrowserBinding>() {

    private var code: String? = null
    private var public_travis_token: String? = null
    private var private_travis_token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        processIntent()
    }

    private fun processIntent() {
        val intentFromBrowser = intent
        if (intentFromBrowser != null) {
            val uri: Uri? = intentFromBrowser.data
            if (uri != null && uri.toString().startsWith(CALLBACK_URL)) {
                code = uri.getQueryParameter("code")
                Log.d("CODE:", code)
                mViewModel.getTravisToken(code)
//                getTravisToken(code, object : IAPICallBack<TravisTokens?>() {
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
