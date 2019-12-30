package ir.rezarasoulzadeh.digikala.model.keys

import android.os.Parcelable
import ir.rezarasoulzadeh.digikala.model.SubCategory
import kotlinx.android.parcel.Parcelize


@Parcelize
class SubCategoryKey(
    var subCategoies: ArrayList<SubCategory>? = ArrayList()
) : Parcelable{
    companion object{
        const val KEY = "SubCategory"
    }
}