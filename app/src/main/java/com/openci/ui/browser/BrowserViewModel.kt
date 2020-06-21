package com.openci.ui.browser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openci.data.repository.login.LoginRepository
import com.openci.models.GitHubAccessToken
import com.openci.models.TravisAccessToken
import com.openci.utils.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@ExperimentalCoroutinesApi
class BrowserViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {

    private lateinit var githubAccessToken: State<GitHubAccessToken>
    private lateinit var publicTravisAccessToken: State<TravisAccessToken>
    private lateinit var privateTravisAccessToken: State<TravisAccessToken>

    fun getGithubAccessToken(code: String?): State<GitHubAccessToken> {
        runBlocking {
            code?.let { it ->
                loginRepository.getGithubAccessToken(it).collect {
                    githubAccessToken = it
                }
            }
        }
        return githubAccessToken
    }

    fun getPublicTravisAccessToken(githubAccessToken: String?): State<TravisAccessToken> {
        runBlocking {
            githubAccessToken?.let { it ->
                loginRepository.getPublicTravisAccessToken(it).collect {
                    publicTravisAccessToken = it
                }
            }
        }
        return publicTravisAccessToken
    }

    fun getPrivateTravisAccessToken(githubAccessToken: String?): State<TravisAccessToken> {
        runBlocking {
            githubAccessToken?.let { it ->
                loginRepository.getPrivateTravisAccessToken(it).collect {
                    privateTravisAccessToken = it
                }
            }
        }
        return privateTravisAccessToken
    }

}