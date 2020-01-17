package ir.rezarasoulzadeh.digikala.service.utils

import android.content.Context
import ir.rezarasoulzadeh.digikala.R
import java.text.NumberFormat
import java.util.*

class Format(var context: Context) {

    fun priceFormat(price: Int): String {
        return NumberFormat
            .getNumberInstance(Locale.US)
            .format(priceTooman(price))
            .toString()
            .plus(context.getString(R.string.characterToomanText))
    }

    fun priceTooman(price: Int): Int {
        return price / 10
    }

    fun rateFormatString(rate: Float) : String {
        val rateFloat = rateFormatFloat(rate)
        val maxFloat = 5
        return rateFloat
            .toString()
            .plus(" ")
            .plus(context.getString(R.string.productAsTitle))
            .plus(" ")
            .plus(maxFloat)
    }

    fun rateFormatFloat(rate: Float) : Float {
        return String.format("%.1f", (rate * 5/ 100)).toFloat()
    }

    fun voteFormat(vote: Int) : String {
        return context.getString(R.string.productFromTitle)
            .plus(" ")
            .plus(vote)
            .plus(" ")
            .plus(context.getString(R.string.productAcceptCommentTitle))
    }

    fun storeFormat(store: Int) : String {
        return store
            .toString()
            .plus(" ")
            .plus(context.getString(R.string.productStoreNumTitle))
    }

    fun storeTextFormat(name:String, rate:Int) : String {
        return "فروش توسط "
            .plus(name)
            .plus(" ")
            .plus(context.getString(R.string.characterDividerText))
            .plus(" ")
            .plus(context.getString(R.string.productShopSatisfyTitle))
            .plus(" ")
            .plus(rate.toString())
            .plus(context.getString(R.string.characterPercentText))
    }

    fun digikalaTextFormat() : String {
        return context.getString(R.string.productShopWithDigikalaTitle)
    }

    fun colourFormat(colourNum: Int) : String {
        return colourNum
            .toString()
            .plus(" ")
            .plus(context.getString(R.string.productColourTitle))
    }

    fun sizeFormat(colourNum: Int) : String {
        return colourNum
            .toString()
            .plus(" ")
            .plus(context.getString(R.string.productSizeTitle))
    }

}