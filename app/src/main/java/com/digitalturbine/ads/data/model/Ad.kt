package com.digitalturbine.ads.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Parcelize
@Root(name = "ad")
data class Ad @JvmOverloads constructor(
    @field: Element(name = "appId", required = false) var appId: String = "",
    @field: Element(name = "appPrivacyPolicyUrl", required = false) var appPrivacyPolicyUrl: String = "",
    @field: Element(name = "averageRatingImageURL", required = false) var averageRatingImageURL: String = "",
    @field: Element(name = "bidRate", required = false) var bidRate: String = "",
    @field: Element(name = "billingTypeId", required = false) var billingTypeId: String = "",
    @field: Element(name = "callToAction", required = false) var callToAction: String = "",
    @field: Element(name = "campaignDisplayOrder", required = false) var campaignDisplayOrder: String = "",
    @field: Element(name = "campaignId", required = false) var campaignId: String = "",
    @field: Element(name = "campaignTypeId", required = false) var campaignTypeId: String = "",
    @field: Element(name = "categoryName", required = false) var categoryName: String = "",
    @field: Element(name = "clickProxyURL", required = false) var clickProxyURL: String = "",
    @field: Element(name = "creativeId", required = false) var creativeId: String = "",
    @field: Element(name = "externalMetadata", required = false) var externalMetadata: ExternalMetadata? = null,
    @field: Element(name = "homeScreen", required = false) var homeScreen: String = "",
    @field: Element(name = "impressionTrackingURL", required = false) var impressionTrackingURL: String = "",
    @field: Element(name = "isRandomPick", required = false) var isRandomPick: String = "",
    @field: Element(name = "minOSVersion", required = false) var minOSVersion: String = "",
    @field: Element(name = "numberOfDownloads", required = false) var numberOfDownloads: String = "",
    @field: Element(name = "numberOfRatings", required = false) var numberOfRatings: String = "",
    @field: Element(name = "postInstallActions", required = false) var postInstallActions: String = "",
    @field: Element(name = "productDescription", required = false) var productDescription: String = "",
    @field: Element(name = "productId", required = false) var productId: String = "",
    @field: Element(name = "productName", required = false) var productName: String = "",
    @field: Element(name = "productThumbnail", required = false) var productThumbnail: String = "",
    @field: Element(name = "rating", required = false) var rating: String = "",
    @field: Element(name = "stiEnabled", required = false) var stiEnabled: String = "",
    @field: Element(name = "tstiEligible", required = false) var tstiEligible: String = ""
): Parcelable