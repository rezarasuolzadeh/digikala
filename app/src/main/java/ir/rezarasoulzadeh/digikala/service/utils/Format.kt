package ir.rezarasoulzadeh.digikala.service.utils

import java.text.NumberFormat
import java.util.*

class Format {

    fun priceFormat(price: Int): String {
        return NumberFormat.getNumberInstance(Locale.US).format(priceToman(price)).toString().plus(" تومان")
    }

    fun priceToman(price: Int): Int {
        return price / 10
    }

    fun rateFormatString(rate: Int) : String {
        val rateFloat = rateFormatFloat(rate)
        val maxFloat = 5
        return rateFloat.toString().plus(" از ").plus(maxFloat)
    }

    fun rateFormatFloat(rate: Int) : Float {
        return (rate * 5/ 100).toFloat()
    }

    fun voteFormat(vote: Int) : String {
        return "از مجوع ".plus(vote).plus(" رای ثبت شده")
    }

}