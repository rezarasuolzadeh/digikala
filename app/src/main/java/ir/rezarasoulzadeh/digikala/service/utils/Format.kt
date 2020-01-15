package ir.rezarasoulzadeh.digikala.service.utils

import java.text.NumberFormat
import java.util.*

class Format {


    fun priceFormat(price: Int): String {
        return NumberFormat.getNumberInstance(Locale.US).format(priceTooman(price)).toString().plus("تومان")
    }

    fun priceTooman(price: Int): Int {
        return price / 10
    }

    fun rateFormatString(rate: Float) : String {
        val rateFloat = rateFormatFloat(rate)
        val maxFloat = 5
        return rateFloat.toString().plus(" از ").plus(maxFloat)
    }

    fun rateFormatFloat(rate: Float) : Float {
        return String.format("%.1f", (rate * 5/ 100)).toFloat()
    }

    fun voteFormat(vote: Int) : String {
        return "از مجموع ".plus(vote).plus(" رای ثبت شده")
    }

    fun storeFormat(store: Int) : String {
        return store.toString().plus(" از")
    }

    fun storeTextFormat(name:String, rate:Int) : String {
        return "فروش توسط ".plus(name).plus(" | ").plus("رضایت خرید: ").plus(rate.toString()).plus("%")
    }

    fun digikalaTextFormat() : String {
        return "فروش توسط دیجیکالا"
    }

    fun colourFormat(colourNum: Int) : String {
        return colourNum.toString().plus(" رنگ")
    }

    fun sizeFormat(colourNum: Int) : String {
        return colourNum.toString().plus(" سایز")
    }

}