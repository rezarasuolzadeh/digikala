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
        "Mobile-Agent: MobileApp/Android/v-47/503eaa6d3af99023"
    )

    @GET("ProductCache/GetAlbumByProductId/{productId}")
    suspend fun getProductAlbum(@Path("productId") productId: Int): Response<ProductAlbum>

    @GET("ProductCache/GetProductById/")
    suspend fun getProducInfo(@Query("") productId: Int): Response<ProductInfo>

    @GET("ProductCache/GetProductDefaultConfigById")
    suspend fun getProductConfig(@Query("id") productId: Int): Response<ProductConfig>

    @GET("ProductCache/GetSpecificationByProductId/")
    suspend fun getProductSpecification(@Query("") productId: Int): Response<ProductSpecific>

    @GET("ProductCache/GetUserRateInfoByProductId/")
    suspend fun getProductRate(@Query("") productId: Int): Response<ProductRate>

}