package ir.rezarasoulzadeh.digikala.interfaces

import ir.rezarasoulzadeh.digikala.model.Banner
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BannerDao {

    @Headers(
        "ApplicationType: AppAndroid",
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent: MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("Banner/GetMobileBanner")
    suspend fun getBanner(): Response<Banner>

}