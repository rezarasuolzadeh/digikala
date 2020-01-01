package ir.rezarasoulzadeh.digikala.interfaces

import ir.rezarasoulzadeh.digikala.model.Lists
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ListsDao {

    @Headers(
        "ApplicationType: AppAndroid",
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent: MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("search/get/")
    suspend fun getLists(
        @Query("sortBy") sortBy: Int,
        @Query("status") status: Int,
        @Query("pageSize") pageSize: Int,
        @Query("pageno") pageno: Int,
        @Query("mobile") mobile: Int
    ): Response<Lists>

}