package com.example.daggerdemo.user

import com.example.daggerdemo.storage.Storage
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserManager @Inject constructor(private val storage: Storage,private val userComponentFactory: UserComponent.Factory) {
    private val REGISTERED_USER = "registered_user"
    private val PASSWORD_SUFFIX = "password"

    /**
     *  UserDataRepository is specific to a logged in user. This determines if the user
     *  is logged in or not, when the user logs in, a new instance will be created.
     *  When the user logs out, this will be null.
     */
    // var userDataRepository: UserDataRepository? = null
    // Add or edit the following lines
    var userComponent: UserComponent? = null
        private set
     val username: String
        get() = storage.getString(REGISTERED_USER)

    fun isUserLoggedIn() = userComponent != null

    fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

    fun registerUser(username: String, password: String) {
        storage.setString(REGISTERED_USER, username)
        storage.setString("$username$PASSWORD_SUFFIX", password)
        userJustLoggedIn()
    }

    fun loginUser(username: String, password: String): Boolean {
        val registeredUser = this.username
        if (registeredUser != username) return false

        val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
        if (registeredPassword != password) return false

        userJustLoggedIn()
        return true
    }

     fun logout() {
         userComponent = null
    }

    fun unregister() {
        val username = storage.getString(REGISTERED_USER)
        storage.setString(REGISTERED_USER, "")
        storage.setString("$username$PASSWORD_SUFFIX", "")
        logout()
    }

    private fun userJustLoggedIn() {
        userComponent=  userComponentFactory.create()
    }
}