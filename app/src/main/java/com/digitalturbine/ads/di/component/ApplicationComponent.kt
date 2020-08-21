package com.digitalturbine.ads.di.component

import android.app.Application
import com.digitalturbine.ads.app.App
import com.digitalturbine.ads.di.module.*

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    MainFragmentBindingModule::class,
    AdApiModule::class,
    ApplicationModule::class,
    ContextModule::class
]
)

interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}