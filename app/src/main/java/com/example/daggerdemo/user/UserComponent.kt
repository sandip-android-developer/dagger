package com.example.daggerdemo.user

import com.example.daggerdemo.main.MainActivity
import com.example.daggerdemo.setting.SettingsActivity
import dagger.Subcomponent

@LoggedUserScope
@Subcomponent
interface UserComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():UserComponent
    }
    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)
    fun inject(activity: SettingsActivity)
}