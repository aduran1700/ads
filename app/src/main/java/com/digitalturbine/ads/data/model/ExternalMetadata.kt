package com.digitalturbine.ads.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Parcelize
@Root(name = "externalMetadata")
data class ExternalMetadata(
    @field:Attribute(name = "xmlns:xsi", required = false) var xmlns_xsi: String = "",
    @field:Attribute(name = "nil", required = false) var xsi_nil: String = ""
): Parcelable