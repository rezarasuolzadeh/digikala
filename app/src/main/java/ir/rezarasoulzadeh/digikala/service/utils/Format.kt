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

}