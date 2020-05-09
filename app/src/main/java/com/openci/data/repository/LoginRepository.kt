package com.openci.data.repository

import android.R
import android.util.Log
import com.openci.data.remote.api.GitHubAuthService
import com.openci.data.remote.api.TravisAuthService
import com.openci.models.GitHubAccessToken
import com.openci.models.GitHubConfigHelper.getClientID
import com.openci.models.GitHubConfigHelper.getSecret
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Singleton
class LoginRepository @Inject constructor(
    @Named("github_auth_service") private val gitHubAuthService: GitHubAuthService,
    @Named("public_travis_auth_service") private val publicTravisAuthService: TravisAuthService,
    @Named("private_travis_auth_service") private val privateTravisAuthService: TravisAuthService
) {

    private val CLIENT_ID = getClientID()
    private val CLIENT_SECRET = getSecret()

    /**
     * First we obtain the GitHub access_token in getTravisToken() and
     * upon success, we proceed to exchange it for Public Travis access_token
     * and Private Travis access_token in getPublicToken() & getPrivateToken() respectively
     * @param code
     * @param callback
     */
    fun getTravisToken(code: String) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val test = gitHubAuthService.getGitHubAccessToken(CLIENT_ID, CLIENT_SECRET, code)
                Log.d("Github Token : ", test.toString())
//                titleRefreshCallback.onCompleted()
            } catch (throwable: Throwable) {
//                titleRefreshCallback.onError(throwable)
            }
        }
    }
}