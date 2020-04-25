package com.openci.di

import com.openci.di.login.LoginModule
import com.openci.di.login.LoginScope
import com.openci.di.login.LoginViewModelModule
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

}