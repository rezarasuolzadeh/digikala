package ir.rezarasoulzadeh.digikala.interfaces

import ir.rezarasoulzadeh.digikala.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDao {

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent:MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("ProductCache/GetAlbumByProductId/{productId}")
    suspend fun getProductAlbum(@Path("productId") productId: Int): Response<ProductAlbum>

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent:MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("ProductCache/GetProductById/{productId}")
    suspend fun getProductInfo(@Path("productId") productId: Int): Response<ProductInfo>

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent:MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("ProductCache/GetProductDefaultConfigById")
    suspend fun getProductConfig(@Query("id") productId: Int): Response<ProductConfig>

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent:MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("ProductCache/GetSpecificationByProductId/")
    suspend fun getProductSpecification(@Query("") productId: Int): Response<ProductSpecific>

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent:MobileApp/Android/v-47/503eaa6d3af99023"
    )
    @GET("ProductCache/GetUserRateInfoByProductId/")
    suspend fun getProductRate(@Query("") productId: Int): Response<ProductRate>

}