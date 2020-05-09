package com.openci.di

import android.app.Application
import com.openci.OpenCIApp
import com.openci.di.browser.BrowserModule
import com.openci.di.browser.BrowserViewModelModule
import com.openci.di.login.LoginModule
import com.openci.di.login.LoginViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        OpenCIApiModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<OpenCIApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: OpenCIApp)
}