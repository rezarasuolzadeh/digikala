package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName


data class Lists(
    @SerializedName("hits")
    val hits: ListsHits = ListsHits(),
    @SerializedName("trackerData")
    val trackerData: ListsTrackerData = ListsTrackerData()
)

data class ListsHits(
    @SerializedName("hits")
    val hits: List<ListsHit> = listOf()
)

data class ListsHit(
    @SerializedName("_id")
    val id: Int = 0, // 1750478
    @SerializedName("_source")
    val source: ListsSource = ListsSource()
)

    data class ListsSource(
    @SerializedName("Brand")
    val brand: Brand = Brand(),
    @SerializedName("CpcData")
    val cpcData: List<Any> = listOf(),
    @SerializedName("EnTitle")
    val enTitle: String = "", // Nokia 3.2 Dual SIM 64GB Mobile Phone
    @SerializedName("ExistStatus")
    val existStatus: Int = 0, // 2
    @SerializedName("FaTitle")
    val faTitle: String = "", // گوشی موبایل نوکیا مدل 3.2 دو سیم کارت با ظرفیت 64 گیگابایت
    @SerializedName("Id")
    val id: Int = 0, // 1750478
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-products/112654126.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_90
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
    val minPrice: Int = 0, // 16450000
    @SerializedName("MinPriceList")
    val minPriceList: Int = 0, // 0
    @SerializedName("ProductColorList")
    val productColorList: List<ListsProductColor> = listOf(),
    @SerializedName("Rate")
    val rate: Int = 0, // 0
    @SerializedName("ShowType")
    val showType: Int = 0, // 2
    @SerializedName("UserRating")
    val userRating: Int = 0 // 88
)

data class ListsBrand(
    @SerializedName("Id")
    val id: Int = 0, // 20
    @SerializedName("Title")
    val title: String = "" // Nokia
)

data class ListsProductColor(
    @SerializedName("ColorCode")
    val colorCode: String = " ", // #212121
    @SerializedName("ColorHex")
    val colorHex: String = "", // #212121
    @SerializedName("ColorId")
    val colorId: Int = 0, // 1
    @SerializedName("ColorTitle")
    val colorTitle: String = "", // مشکی
    @SerializedName("IsActive")
    val isActive: Boolean = false, // true
    @SerializedName("ProductId")
    val productId: Int = 0 // 1750478
)

data class ListsTrackerData(
    @SerializedName("categoryId")
    val categoryId: Any = Any(), // null
    @SerializedName("foundItems")
    val foundItems: Int = 0, // 940955
    @SerializedName("os")
    val os: Int = 0, // 3
    @SerializedName("page")
    val page: Int = 0, // 1
    @SerializedName("pages")
    val pages: Int = 0, // 58810
    @SerializedName("products")
    val products: List<ListsProduct> = listOf(),
    @SerializedName("source")
    val source: Int = 0 // 1
)

data class ListsProduct(
    @SerializedName("brand_id")
    val brandId: Int = 0, // 20
    @SerializedName("category_id")
    val categoryId: Int = 0, // 11
    @SerializedName("is_sponsored")
    val isSponsored: Boolean = false, // false
    @SerializedName("product_id")
    val productId: Int = 0 // 1750478
)