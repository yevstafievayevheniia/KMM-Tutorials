package org.jarvist.kmmapp6.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("rate")
    val rate: Double? = null
)