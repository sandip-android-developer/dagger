package com.example.daggerdemo.registration

import com.example.daggerdemo.di.ActivityScope
import com.example.daggerdemo.registration.enterdetails.EnterDetailsFragment
import com.example.daggerdemo.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory{
        fun onCreate():RegistrationComponent
    }
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)

}