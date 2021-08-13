package com.example.daggerdemo.di

import com.example.daggerdemo.login.LoginComponent
import com.example.daggerdemo.registration.RegistrationComponent
import com.example.daggerdemo.user.UserComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class,LoginComponent::class, UserComponent::class])
class AppSubcomponents {
}