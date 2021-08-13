package com.example.daggerdemo.registration.enterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject


class EnterDetailsViewModel @Inject constructor() {
    private val MAX_LENGTH = 5
    private val _enterDetailsState = MutableLiveData<EnterDetailsFragment.EnterDetailsViewState>()
    val enterDetailsState: LiveData<EnterDetailsFragment.EnterDetailsViewState>
        get() = _enterDetailsState

    fun validateInput(username: String, password: String) {
        when {
            username.length < MAX_LENGTH -> _enterDetailsState.value =
                EnterDetailsFragment.EnterDetailsError("Username has to be longer than 4 characters")
            password.length < MAX_LENGTH -> _enterDetailsState.value =
                EnterDetailsFragment.EnterDetailsError("Password has to be longer than 4 characters")
            else -> _enterDetailsState.value = EnterDetailsFragment.EnterDetailsSuccess
        }
    }
}