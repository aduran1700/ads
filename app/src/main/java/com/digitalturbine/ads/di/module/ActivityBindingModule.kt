package com.digitalturbine.ads.di.module


import com.digitalturbine.ads.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentBindingModule::class])
    internal abstract fun bindMainActivity() : MainActivity
}