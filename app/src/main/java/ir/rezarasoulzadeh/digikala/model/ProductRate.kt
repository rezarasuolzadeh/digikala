package ir.rezarasoulzadeh.digikala.model

import com.google.gson.annotations.SerializedName


data class ProductRate(
    @SerializedName("Data")
    val `data`: ProductRateData = ProductRateData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductRateData(
    @SerializedName("CategoryRateInfos")
    val categoryRateInfos: List<ProductRateCategoryRateInfo> = listOf(),
    @SerializedName("rateCounter")
    val rateCounter: Int = 0 // 760
)

data class ProductRateCategoryRateInfo(
    @SerializedName("CategoryId")
    val categoryId: Int = 0, // 1272
    @SerializedName("CategoryTitle")
    val categoryTitle: String = "", // پاوربانک (شارژر همراه)
    @SerializedName("RateFactorInfos")
    val rateFactorInfos: List<ProductRateFactorInfo> = listOf()
)

data class ProductRateFactorInfo(
    @SerializedName("Id")
    val id: Int = 0, // 407
    @SerializedName("RateAverage")
    val rateAverage: Double = 0.0, // 82.2
    @SerializedName("Title")
    val title: String = "" // کیفیت
)