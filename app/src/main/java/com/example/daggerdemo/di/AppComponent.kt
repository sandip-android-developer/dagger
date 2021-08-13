package com.example.daggerdemo.di

import android.content.Context
import com.example.daggerdemo.login.LoginComponent
import com.example.daggerdemo.main.MainActivity
import com.example.daggerdemo.registration.RegistrationActivity
import com.example.daggerdemo.registration.RegistrationComponent
import com.example.daggerdemo.registration.enterdetails.EnterDetailsFragment
import com.example.daggerdemo.registration.termsandconditions.TermsAndConditionsFragment
import com.example.daggerdemo.setting.SettingsActivity
import com.example.daggerdemo.user.UserManager
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton


@Singleton
@Component(modules = [StorageModule::class,AppSubcomponents::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Types that can be retrieved from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    fun userManager(): UserManager

}