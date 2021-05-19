package com.pensource.oxygrant.oxygrant_provider.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.pensource.oxygrant.oxygrant_provider.data.repositories.UserRepository
import com.pensource.oxygrant.oxygrant_provider.utils.startLoginActivity


class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}