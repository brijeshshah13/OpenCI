package com.openci.di.browser

import com.openci.data.remote.api.GitHubAuthService
import com.openci.data.remote.api.TravisAuthService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
object BrowserModule {

    @BrowserScope
    @Provides
    @Named("github_auth_service")
    fun provideGitHubAuthService(@Named("github_client") retrofit: Retrofit): GitHubAuthService {
        return retrofit.create(GitHubAuthService::class.java)
    }

    @BrowserScope
    @Provides
    @Named("public_travis_auth_service")
    fun providePublicTravisAuthService(@Named("travis_public_client") retrofit: Retrofit): TravisAuthService {
        return retrofit.create(TravisAuthService::class.java)
    }

    @BrowserScope
    @Provides
    @Named("private_travis_auth_service")
    fun providePrivateTravisAuthService(@Named("travis_private_client") retrofit: Retrofit): TravisAuthService {
        return retrofit.create(TravisAuthService::class.java)
    }
}