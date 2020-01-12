package ir.rezarasoulzadeh.digikala.model

import com.google.gson.annotations.SerializedName


data class ProductConfig(
    @SerializedName("Data")
    val `data`: ProductConfigData = ProductConfigData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductConfigData(
    @SerializedName("Colors")
    val colors: List<ProductConfigColor> = listOf(),
    @SerializedName("ConfigNum")
    val configNum: Int = 0, // 7
    @SerializedName("ConfigViewModel")
    val configViewModel: ProductConfigViewModel = ProductConfigViewModel(),
    @SerializedName("Sizes")
    val sizes: Any = Any() // null
)

data class ProductConfigColor(
    @SerializedName("Code")
    val code: String = " ", // #212121
    @SerializedName("HexCode")
    val hexCode: String = "", // #212121
    @SerializedName("Id")
    val id: Int = 0, // 1
    @SerializedName("Title")
    val title: String = "" // مشکی
)

data class ProductConfigViewModel(
    @SerializedName("Color")
    val color: ProductColorX = ProductColorX(),
    @SerializedName("DefaultBuyBox")
    val defaultBuyBox: Boolean = false, // true
    @SerializedName("DigibonReceived")
    val digibonReceived: Int = 0, // 0
    @SerializedName("DigibonUsable")
    val digibonUsable: Int = 0, // 0
    @SerializedName("Discount")
    val discount: Int = 0, // 210000
    @SerializedName("Gifts")
    val gifts: Any = Any(), // null
    @SerializedName("Id")
    val id: Int = 0, // 1087993
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // false
    @SerializedName("MaxCount")
    val maxCount: Int = 0, // 30
    @SerializedName("Payable")
    val payable: Int = 0, // 2190000
    @SerializedName("Price")
    val price: Int = 0, // 2400000
    @SerializedName("PriceId")
    val priceId: Int = 0, // 150487084
    @SerializedName("Seller")
    val seller: ProductConfigSeller = ProductConfigSeller(),
    @SerializedName("SellerRatesCount")
    val sellerRatesCount: Int = 0, // 0
    @SerializedName("SellerRating")
    val sellerRating: Int = 0, // 0
    @SerializedName("Size")
    val size: Any = Any(), // null
    @SerializedName("Warranty")
    val warranty: ProductConfigWarranty = ProductConfigWarranty()
)

data class ProductColorX(
    @SerializedName("Code")
    val code: String = "", // #FFFFFF
    @SerializedName("HexCode")
    val hexCode: String = "", // #FFFFFF
    @SerializedName("Id")
    val id: Int = 0, // 2
    @SerializedName("Title")
    val title: String = "" // سفید
)

data class ProductConfigSeller(
    @SerializedName("ConfigId")
    val configId: Int = 0, // 1087993
    @SerializedName("FullName")
    val fullName: String = "", // دیجی‌کالا
    @SerializedName("Id")
    val id: Int = 0, // 1
    @SerializedName("LeadTime")
    val leadTime: Int = 0, // 0
    @SerializedName("LogoPath")
    val logoPath: String = ""
)

data class ProductConfigWarranty(
    @SerializedName("Id")
    val id: Int = 0, // 765
    @SerializedName("Title")
    val title: String = "" // گارانتی 18 ماهه آواژنگ
)