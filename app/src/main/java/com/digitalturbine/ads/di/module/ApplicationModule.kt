package com.digitalturbine.ads.di.module

import com.digitalturbine.ads.api.AdApi
import com.digitalturbine.ads.data.repository.AdRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideAdRepository(api: AdApi) = AdRepository(api)
}