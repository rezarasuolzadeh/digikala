package ir.rezarasoulzadeh.digikala.service.config

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceRetrofitConfig {

    private const val digikalaUrl = "https://service2.digikala.com/api/"

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