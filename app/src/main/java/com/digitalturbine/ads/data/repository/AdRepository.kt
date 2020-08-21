package com.digitalturbine.ads.data.repository

import com.digitalturbine.ads.api.AdApi
import io.reactivex.schedulers.Schedulers

class AdRepository(
    private val api: AdApi
) {
    fun getAds() = api.getAds().map {
        it.adList
    }.subscribeOn(Schedulers.io())
        .onErrorReturn {
            emptyList()
        }
}