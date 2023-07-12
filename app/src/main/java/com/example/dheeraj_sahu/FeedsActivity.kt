package com.example.dheeraj_sahu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeedsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feeds) // Set the feeds.xml layout here

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch images from the API
        val images = fetchImagesFromApi()
        imageAdapter = ImageAdapter(images)
        recyclerView.adapter = imageAdapter
    }

    private fun fetchImagesFromApi(): List<ImageData> {
        // Make network request to fetch images using the API service
        // Replace "YourApiServiceEndpoint" with the actual API endpoint URL
        val apiService = createApiService("https://api.pexels.com/v1/search?query=nature&per_page=10")
        return try {
            runBlocking {
                apiService.getImages()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle the error or return an empty list
            emptyList()
        }
    }
        private fun createApiService(apiUrl: String): ApiService {
            val apiKey = "7SqpvzfAH4ittiMHHzZXxM8OXsdeRNmr8TBObV1SD9pUppnaEKPXGRLU" // Replace with your actual API key

            val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val originalRequest = chain.request()
                    val newUrl = originalRequest.url.newBuilder()
                        .addQueryParameter("api_key", apiKey)
                        .build()

                    val newRequest = originalRequest.newBuilder()
                        .url(newUrl)
                        .build()

                    chain.proceed(newRequest)
                }
                .build()

            val gson = GsonBuilder().create()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.pexels.com/") // Replace with your actual base URL
                .client(client  )
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiService::class.java)
    }
}
// For some reasons I am not able to fetch the data from public api but i will in 2-3 days please give me the chance

