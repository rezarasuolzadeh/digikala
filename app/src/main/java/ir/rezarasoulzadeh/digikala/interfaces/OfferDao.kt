package ir.rezarasoulzadeh.digikala.interfaces

import ir.rezarasoulzadeh.digikala.model.Offer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface OfferDao {

    @Headers(
        "ApplicationVersion: 1.9.6-CB",
        "Mobile-Agent: MobileApp/Android/v-47/503eaa6d3af99023"
    )

    @GET("IncredibleOffer/GetIncredibleOffer")
    suspend fun getOffer(): Response<Offer>

}