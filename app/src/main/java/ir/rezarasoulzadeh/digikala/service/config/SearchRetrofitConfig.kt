package ir.rezarasoulzadeh.digikala.service.config

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SearchRetrofitConfig {
    private const val digikalaUrl = "https://search.digikala.com/api2/"

    fun retrofit() : Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(digikalaUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}