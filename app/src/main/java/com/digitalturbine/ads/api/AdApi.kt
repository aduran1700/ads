package com.digitalturbine.ads.api

import com.digitalturbine.ads.data.model.Ads
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AdApi {

    @GET("getAds")
    fun getAds(@Query("id") id: Int = 236,
               @Query("password") password: String = "OVUJ1DJN",
               @Query("siteId") siteId: Int = 10777,
               @Query("deviceId") deviceId: Int = 4230,
               @Query("sessionId") sessionId: String = "techtestsession",
               @Query("totalCampaignsRequested") totalCampaignsRequested: Int = 10,
               @Query("Iname") lastName: String = "Duran"
    ): Single<Ads>
}