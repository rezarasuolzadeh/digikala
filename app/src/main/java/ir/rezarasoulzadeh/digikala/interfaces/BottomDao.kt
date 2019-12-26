package ir.rezarasoulzadeh.digikala.interfaces

import ir.rezarasoulzadeh.digikala.model.Bottom
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BottomDao {

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent: MobileApp/Android/v-47/503eaa6d3af99023"
    )

    @GET("search/get/?category=c11&pageSize=16&sortBy=10&pageno=0&mobile=1")
    suspend fun getBottom(
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("sortBy") sortBy: Int,
        @Query("pageno") pageno: Int,
        @Query("mobile") mobile: Int
    ): Response<Bottom>

}