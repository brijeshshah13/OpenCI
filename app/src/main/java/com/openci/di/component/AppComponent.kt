package com.openci.di.component

import android.app.Application
import com.openci.OpenCIApp
import com.openci.di.builder.ActivityBuilder
import com.openci.di.module.OpenCIApiModule
import com.openci.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
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