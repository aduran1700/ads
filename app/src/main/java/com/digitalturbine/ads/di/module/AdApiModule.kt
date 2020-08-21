package com.digitalturbine.ads.di.module

import com.digitalturbine.ads.api.AdApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Module
class AdApiModule {

    @Provides
    fun provideClient(): OkHttpClient {
        val clientBuilder = OkHttpClient().newBuilder()
        return clientBuilder.build()
    }

    @Provides
    fun provideRetroFit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAdApi(): AdApi {
        return provideRetroFit(BASE_URL, provideClient()).create(AdApi::class.java)
    }

    companion object {
        const val BASE_URL = "https://ads.appia.com"
    }
}

