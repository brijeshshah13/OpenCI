package com.openci.ui.browser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openci.data.repository.LoginRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class BrowserViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {

    fun getTravisToken(code: String?) {
        viewModelScope.launch {
            code?.let { loginRepository.getTravisToken(it) }
        }
    }
}