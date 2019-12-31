package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName


data class ProductAlbum(
    @SerializedName("Data")
    val `data`: List<ProductAlbumData> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductAlbumData(
    @SerializedName("ImagePaths")
    val imagePaths: ProductAlbumPath = ProductAlbumPath(),
    @SerializedName("ProductPhotoId")
    val productPhotoId: Int = 0, // 4
    @SerializedName("Row")
    val row: Int = 0, // 4
    @SerializedName("sort")
    val sort: Int = 0, // 5
    @SerializedName("type")
    val type: Int = 0 // 5
)

data class ProductAlbumPath(
    @SerializedName("Original")
    val original: String = "", // https://dkstatics-public.digikala.com/digikala-products/446515.jpg?x-oss-process=image/resize,h_1600/quality,q_80
    @SerializedName("Size110")
    val size110: String = "", // https://dkstatics-public.digikala.com/digikala-products/446515.jpg?x-oss-process=image/resize,w_110/quality,q_60
    @SerializedName("Size180")
    val size180: String = "", // https://dkstatics-public.digikala.com/digikala-products/446515.jpg?x-oss-process=image/resize,w_180/quality,q_60
    @SerializedName("Size220")
    val size220: String = "", // https://dkstatics-public.digikala.com/digikala-products/446515.jpg?x-oss-process=image/resize,w_220/quality,q_60
    @SerializedName("Size70")
    val size70: String = "" // https://dkstatics-public.digikala.com/digikala-products/446515.jpg?x-oss-process=image/resize,w_70/quality,q_60
)