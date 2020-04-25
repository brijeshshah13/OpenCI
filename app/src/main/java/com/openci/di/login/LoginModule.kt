package com.openci.di.login

import com.openci.data.remote.api.GitHubAuthService
import com.openci.data.remote.api.TravisAuthService
import dagger.Provides
import retrofit2.Retrofit

object LoginModule {

    @LoginScope
    @Provides
    fun provideGitHubAuthService(retrofit: Retrofit): GitHubAuthService {
        return retrofit.create(GitHubAuthService::class.java)
    }

    @LoginScope
    @Provides
    fun provideTravisAuthService(retrofit: Retrofit): TravisAuthService {
        return retrofit.create(TravisAuthService::class.java)
    }
}