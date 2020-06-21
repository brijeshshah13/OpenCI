package com.openci.data.repository.login

import com.openci.data.remote.api.GitHubAuthService
import com.openci.data.remote.api.TravisAuthService
import com.openci.models.GitHubAccessToken
import com.openci.models.GitHubConfigHelper.getClientID
import com.openci.models.GitHubConfigHelper.getSecret
import com.openci.models.TravisAccessToken
import com.openci.models.TravisTokenRequest
import com.openci.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class LoginRepository @Inject constructor(
    @Named("github_auth_service") private val gitHubAuthService: GitHubAuthService,
    @Named("public_travis_auth_service") private val publicTravisAuthService: TravisAuthService,
    @Named("private_travis_auth_service") private val privateTravisAuthService: TravisAuthService
) {

    private val CLIENT_ID = getClientID()
    private val CLIENT_SECRET = getSecret()

    /**
     * First we obtain the GitHub access_token in getGithubAccessToken() and
     * upon success, we proceed to exchange it for Public Travis access_token
     * and Private Travis access_token in getPublicToken() & getPrivateToken() respectively
     * @param code
     * @param callback
     */
    fun getGithubAccessToken(code: String): Flow<State<GitHubAccessToken>> {
        return object : NetworkBoundRepository<GitHubAccessToken, GitHubAccessToken>() {

            override suspend fun fetchFromRemote(): Response<GitHubAccessToken> = gitHubAuthService.getGitHubAccessToken(CLIENT_ID, CLIENT_SECRET, code)

            override fun getAccessToken(accessToken: GitHubAccessToken): GitHubAccessToken = accessToken

        }.asFlow().flowOn(Dispatchers.IO)
    }

    fun getPublicTravisAccessToken(githubAccessToken: String): Flow<State<TravisAccessToken>> {
        return object : NetworkBoundRepository<TravisAccessToken, TravisAccessToken>() {

            override suspend fun fetchFromRemote(): Response<TravisAccessToken> = publicTravisAuthService.getTravisAccessToken(
                TravisTokenRequest(githubAccessToken)
            )

            override fun getAccessToken(accessToken: TravisAccessToken): TravisAccessToken = accessToken

        }.asFlow().flowOn(Dispatchers.IO)
    }

    fun getPrivateTravisAccessToken(githubAccessToken: String): Flow<State<TravisAccessToken>> {
        return object : NetworkBoundRepository<TravisAccessToken, TravisAccessToken>() {

            override suspend fun fetchFromRemote(): Response<TravisAccessToken> = privateTravisAuthService.getTravisAccessToken(
                TravisTokenRequest(githubAccessToken)
            )

            override fun getAccessToken(accessToken: TravisAccessToken): TravisAccessToken = accessToken

        }.asFlow().flowOn(Dispatchers.IO)
    }

}