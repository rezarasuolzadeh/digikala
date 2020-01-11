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

    fun storeFormat(store: Int) : String {
        return store.toString().plus(" فروشنده و گارانتی برای این کالا وجود دارد")
    }

    fun storeTextFormat(name:String, rate:Int) : String {
        return "فروش توسط ".plus(name).plus(" | ").plus("رضایت خرید: ").plus(rate.toString()).plus("%")
    }

    fun digikalaTextFormat() : String {
        return "فروش توسط دیجیکالا"
    }

}