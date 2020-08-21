package com.digitalturbine.ads.di.module


import com.digitalturbine.ads.ui.adslist.AdListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun provideAdListFragment(): AdListFragment
}