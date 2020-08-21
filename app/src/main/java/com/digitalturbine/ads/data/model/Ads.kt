package com.digitalturbine.ads.data.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ads", strict = false)
data class Ads @JvmOverloads constructor(
    @field:Attribute(required = false) var xmlns: String = "",
    @field:ElementList(inline = true) var adList: List<Ad> = mutableListOf(),
    @field: Element(name = "responseTime", required = false) var responseTime: String = "",
    @field: Element(name = "totalCampaignsRequested", required = false) var totalCampaignsRequested: String = "",
    @field: Element(name = "version", required = false) var version: String = ""
)