package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName


data class Bottom(
    @SerializedName("hits")
    val hits: BottomHits = BottomHits(),
    @SerializedName("trackerData")
    val trackerData: TrackerData = TrackerData()
)

data class BottomHits(
    @SerializedName("hits")
    val hits: List<BottomHit> = listOf()
)

data class BottomHit(
    @SerializedName("_id")
    val id: Int = 0, // 2247456
    @SerializedName("_source")
    val source: BottomSource = BottomSource()
)

data class BottomSource(
    @SerializedName("Brand")
    val brand: BottomBrand = BottomBrand(),
    @SerializedName("CpcData")
    val cpcData: List<Any> = listOf(),
    @SerializedName("EnTitle")
    val enTitle: String = "", // Apple iPhone 8 Plus A1897 64GB Mobile Phone
    @SerializedName("ExistStatus")
    val existStatus: Int = 0, // 2
    @SerializedName("FaTitle")
    val faTitle: String = "", // گوشی موبایل اپل مدل iPhone 8 Plus A1897 ظرفیت 64 گیگابایت
    @SerializedName("Id")
    val id: Int = 0, // 2247456
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-products/114552244.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_90
    @SerializedName("IsFake")
    val isFake: Boolean = false, // false
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // false
    @SerializedName("IsSpecialOffer")
    val isSpecialOffer: Boolean = false, // false
    @SerializedName("IsSponsoredOffer")
    val isSponsoredOffer: Boolean = false, // false
    @SerializedName("LikeCounter")
    val likeCounter: Int = 0, // 0
    @SerializedName("MinPrice")
    val minPrice: Int = 0, // 103000000
    @SerializedName("MinPriceList")
    val minPriceList: Int = 0, // 0
    @SerializedName("ProductColorList")
    val productColorList: List<BottomProductColor> = listOf(),
    @SerializedName("Rate")
    val rate: Int = 0, // 0
    @SerializedName("ShowType")
    val showType: Int = 0, // 2
    @SerializedName("UserRating")
    val userRating: Int = 0 // 90
)

data class BottomBrand(
    @SerializedName("Id")
    val id: Int = 0, // 10
    @SerializedName("Title")
    val title: String = "" // Apple
)

data class BottomProductColor(
    @SerializedName("ColorCode")
    val colorCode: String = "", // #9E9E9E
    @SerializedName("ColorHex")
    val colorHex: String = "", // #9E9E9E
    @SerializedName("ColorId")
    val colorId: Int = 0, // 11
    @SerializedName("ColorTitle")
    val colorTitle: String = "", // خاکستری
    @SerializedName("IsActive")
    val isActive: Boolean = false, // true
    @SerializedName("ProductId")
    val productId: Int = 0 // 2247456
)

data class TrackerData(
    @SerializedName("categoryId")
    val categoryId: String = "", // 11
    @SerializedName("foundItems")
    val foundItems: Int = 0, // 2633
    @SerializedName("os")
    val os: Int = 0, // 3
    @SerializedName("page")
    val page: Int = 0, // 1
    @SerializedName("pages")
    val pages: Int = 0, // 165
    @SerializedName("products")
    val products: List<Product> = listOf(),
    @SerializedName("source")
    val source: Int = 0 // 1
)

data class Product(
    @SerializedName("brand_id")
    val brandId: Int = 0, // 10
    @SerializedName("category_id")
    val categoryId: Int = 0, // 11
    @SerializedName("is_sponsored")
    val isSponsored: Boolean = false, // false
    @SerializedName("product_id")
    val productId: Int = 0 // 2247456
)