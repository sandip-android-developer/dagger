package com.example.daggerdemo.di

import com.example.daggerdemo.storage.SharedPreferencesStorage
import com.example.daggerdemo.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(storage:SharedPreferencesStorage):Storage
}