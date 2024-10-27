package com.example.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailsResponse(
    @SerializedName("name") val superHeroName: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperHeroImageDetailsResponse,
    @SerializedName("biography") val biography: BiographyResponse
    )

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String,
)

data class SuperHeroImageDetailsResponse(
    @SerializedName("url") val url: String
)

data class BiographyResponse(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String,

)