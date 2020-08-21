package com.digitalturbine.ads.di.module

import com.digitalturbine.ads.MainActivity
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {

    @Binds
    internal abstract fun provideMainActivity(activity: MainActivity): MainActivity
}