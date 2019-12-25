package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName


data class Top(
    @SerializedName("responses")
    val responses: List<Responses> = listOf()
)

data class Responses(
    @SerializedName("hits")
    val hits: Hits = Hits()
)

data class Hits(
    @SerializedName("hits")
    val hits: List<Hit> = listOf()
)

data class Hit(
    @SerializedName("_id")
    val id: Int = 0, // 2223368
    @SerializedName("_source")
    val source: Source = Source()
)

data class Source(
    @SerializedName("Brand")
    val brand: Brand = Brand(),
    @SerializedName("CpcData")
    val cpcData: List<Any> = listOf(),
    @SerializedName("EnTitle")
    val enTitle: String = "",
    @SerializedName("ExistStatus")
    val existStatus: Int = 0, // 2
    @SerializedName("FaTitle")
    val faTitle: String = "", // برچسب بدنه خودرو طرح عنکبوت کد 01
    @SerializedName("Id")
    val id: Int = 0, // 2223368
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-products/114422430.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_90
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
    val minPrice: Int = 0, // 120000
    @SerializedName("MinPriceList")
    val minPriceList: Int = 0, // 0
    @SerializedName("ProductColorList")
    val productColorList: List<Any> = listOf(),
    @SerializedName("Rate")
    val rate: Int = 0, // 0
    @SerializedName("ShowType")
    val showType: Int = 0, // 2
    @SerializedName("UserRating")
    val userRating: Int = 0 // 0
)

data class Brand(
    @SerializedName("Id")
    val id: Int = 0, // 719
    @SerializedName("Title")
    val title: String = "" // Miscellaneous
)