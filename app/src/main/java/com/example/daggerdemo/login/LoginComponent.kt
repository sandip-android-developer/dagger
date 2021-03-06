package com.example.daggerdemo.login

import dagger.Subcomponent

@Subcomponent
interface LoginComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): LoginComponent
    }
    // Classes that can be injected by this Component
    fun inject(activity: LoginActivity)

}