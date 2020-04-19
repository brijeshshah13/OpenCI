package com.openci.di

import com.openci.common.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class OpenCIApiModule {

    @Singleton
    @Provides
    @Named("github_client")
    internal fun provideGithubRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.GITHUB_BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

    @Singleton
    @Provides
    @Named("travis_public_client")
    internal fun providePublicTravisRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.PUBLIC_BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

    @Singleton
    @Provides
    @Named("travis_private_client")
    internal fun providePrivateTravisRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.PRIVATE_BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

}