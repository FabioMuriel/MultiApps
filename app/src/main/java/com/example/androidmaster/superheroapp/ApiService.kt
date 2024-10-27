package com.example.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/94e5073d14102d44d6f4f234b6ea2c98/search/{name}")
    suspend fun getSuperheroes(@Path("name") supeheroName: String): Response<SuperHeroDataResponse>

    @GET("/api/94e5073d14102d44d6f4f234b6ea2c98/{id}")
    suspend fun getSuperHeroDetail(@Path("id") superHeroId: String) : Response<SuperHeroDetailsResponse>

}