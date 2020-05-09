package com.openci.di.browser

import androidx.lifecycle.ViewModel
import com.openci.di.ViewModelKey
import com.openci.ui.browser.BrowserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BrowserViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BrowserViewModel::class)
    abstract fun bindBrowserViewModel(viewModel: BrowserViewModel): ViewModel
}