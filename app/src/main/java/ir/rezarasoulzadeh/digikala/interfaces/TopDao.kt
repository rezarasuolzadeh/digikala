package ir.rezarasoulzadeh.digikala.interfaces

import ir.rezarasoulzadeh.digikala.model.Top
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TopDao {

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent: MobileApp/Android/v-47/503eaa6d3af99023"
    )

    @GET("Data/GetAllTopList")
    suspend fun getTop(@Query("mobile") mobile: Int): Response<Top>

}