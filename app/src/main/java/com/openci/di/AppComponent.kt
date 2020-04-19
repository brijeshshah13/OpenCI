package com.openci.di

import android.app.Application
import com.openci.OpenCIApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
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
}