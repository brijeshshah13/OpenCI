package com.openci.di.login

import androidx.lifecycle.ViewModel
import com.openci.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindLoginViewModel(viewModel: AuthViewModel): ViewModel?
}