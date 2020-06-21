package com.openci.di

import android.app.Application
import com.openci.OpenCIApp
import com.openci.di.browser.BrowserModule
import com.openci.di.login.LoginModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [
        // Generic
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        OpenCIApiModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        AppModule::class,

        // Application specific
        LoginModule::class,
        BrowserModule::class
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