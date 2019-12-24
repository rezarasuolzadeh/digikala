package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName
import ir.rezarasoulzadeh.digikala.model.attribute.Data


data class Slider(
    @SerializedName("Data")
    val `data`: List<Data> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)