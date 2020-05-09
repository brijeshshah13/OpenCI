package com.openci.di

import com.openci.di.browser.BrowserModule
import com.openci.di.browser.BrowserScope
import com.openci.di.browser.BrowserViewModelModule
import com.openci.di.login.LoginModule
import com.openci.di.login.LoginScope
import com.openci.di.login.LoginViewModelModule
import com.openci.ui.browser.BrowserActivity
import com.openci.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @LoginScope
    @ContributesAndroidInjector(
        modules = [LoginModule::class, LoginViewModelModule::class]
    )
    abstract fun bindLoginActivity(): LoginActivity

    @BrowserScope
    @ContributesAndroidInjector(
        modules = [BrowserModule::class, BrowserViewModelModule::class]
    )
    abstract fun bindBrowserActivity(): BrowserActivity
}