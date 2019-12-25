package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName


data class Offer(
    @SerializedName("Data")
    val `data`: List<OfferData> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class OfferData(
    @SerializedName("Discount")
    val discount: Int = 0, // 171000
    @SerializedName("Id")
    val id: Int = 0, // 804706
    @SerializedName("ImagePaths")
    val imagePaths: ImagePaths = ImagePaths(),
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // true
    @SerializedName("OnlyForApplication")
    val onlyForApplication: Boolean = false, // false
    @SerializedName("OnlyForMembers")
    val onlyForMembers: Boolean = false, // false
    @SerializedName("Price")
    val price: Int = 0, // 560000
    @SerializedName("ProductId")
    val productId: Int = 0, // 804706
    @SerializedName("Title")
    val title: String = "" // قهوه فوری گلد مولتی کافه - 100 گرم
)

data class ImagePaths(
    @SerializedName("Original")
    val original: String = "", // https://dkstatics-public.digikala.com/digikala-products/3790020.jpg?x-oss-process=image/resize,w_1280/quality,q_80
    @SerializedName("Size110")
    val size110: String = "", // https://dkstatics-public.digikala.com/digikala-products/3790020.jpg?x-oss-process=image/resize,w_110/quality,q_60
    @SerializedName("Size180")
    val size180: String = "", // https://dkstatics-public.digikala.com/digikala-products/3790020.jpg?x-oss-process=image/resize,w_180/quality,q_60
    @SerializedName("Size220")
    val size220: String = "", // https://dkstatics-public.digikala.com/digikala-products/3790020.jpg?x-oss-process=image/resize,w_220/quality,q_60
    @SerializedName("Size70")
    val size70: String = "" // https://dkstatics-public.digikala.com/digikala-products/3790020.jpg?x-oss-process=image/resize,w_70/quality,q_60
)