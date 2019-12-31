package ir.rezarasoulzadeh.digikala.model

import com.google.gson.annotations.SerializedName


data class ProductSpecific(
    @SerializedName("Data")
    val `data`: List<ProductSpecificData> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductSpecificData(
    @SerializedName("CategorySpecTitle")
    val categorySpecTitle: String = "", // مشخصات
    @SerializedName("SpecItems")
    val specItems: List<ProductSpecificSpecItem> = listOf()
)

data class ProductSpecificSpecItem(
    @SerializedName("Item1")
    val item1: String = "", // سایر امکانات و قابلیت‌ها
    @SerializedName("Item2")
    val item2: String = "", // قابلیت اتصال و شارژ دو دستگاه به طور همزمانشدت جریان خروجی در هر یک از درگاه ها به طور مجزا: 3.0 آمپر (در حالت حداکثر)جنس بدنه: پلاستیک مقاوم در برابر خط و خشمحافظت شده در برابر افزایش ولتاژ، جریان و دما
    @SerializedName("Item3")
    val item3: String = ""
)