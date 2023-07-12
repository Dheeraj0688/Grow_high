package com.example.dheeraj_sahu

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("https://api.pexels.com/v1/search?query=nature&per_page=10") // Replace with the actual API endpoint URL
    suspend fun getImages(): List<ImageData>
}
