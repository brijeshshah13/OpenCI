package com.openci.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.openci.common.Constants.PREFS_NAME
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application) : Context

    @Module
    companion object {

        @Singleton
        @JvmStatic
        @Provides
        fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}