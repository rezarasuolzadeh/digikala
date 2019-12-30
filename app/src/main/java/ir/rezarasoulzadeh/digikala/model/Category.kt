package ir.rezarasoulzadeh.digikala.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Category(
    @SerializedName("Data")
    val `data`: List<CategoryData> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class CategoryData(
    @SerializedName("Category")
    val category: CategoryX = CategoryX(),
    @SerializedName("SubCategory")
    val subCategory: List<SubCategory> = listOf()
)

data class CategoryX(
    @SerializedName("HasMainPage")
    val hasMainPage: Boolean = false, // true
    @SerializedName("Id")
    val id: Int = 0, // 10061
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-categories/1000000111.jpg?x-oss-process=image/resize,m_fill,h_144,w_96/quality,q_90
    @SerializedName("QueryStringValue")
    val queryStringValue: String = "", // /dk-ds-gift-card
    @SerializedName("Title")
    val title: String = "", // کارت هدیه
    @SerializedName("UrlCode")
    val urlCode: String = "" // dk-ds-gift-card
)

@Parcelize
data class SubCategory(
    @SerializedName("HasMainPage")
    val hasMainPage: Boolean = false, // false
    @SerializedName("Id")
    val id: Int = 0, // 8102
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-categories/1000000070.jpg?x-oss-process=image/resize,m_fill,h_144,w_96/quality,q_90
    @SerializedName("QueryStringValue")
    val queryStringValue: String = "", // /dk-ds-gift-card/digikala-gift-card
    @SerializedName("Title")
    val title: String = "", // کارت هدیه دیجی کالا
    @SerializedName("UrlCode")
    val urlCode: String = "" // digikala-gift-card
):Parcelable