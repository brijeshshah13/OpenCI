package com.openci.di

import com.openci.di.browser.BrowserScope
import com.openci.di.login.LoginScope
import com.openci.ui.browser.BrowserActivity
import com.openci.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
abstract class ActivityBuilderModule {

    @LoginScope
    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @BrowserScope
    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector
    abstract fun bindBrowserActivity(): BrowserActivity
}