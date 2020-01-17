package ir.rezarasoulzadeh.digikala

import android.content.Context
import ir.rezarasoulzadeh.digikala.service.utils.Format
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FormatPriceTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val price = 1000000
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.characterToomanText)))
            .thenReturn("تومان")
        assertEquals(format.priceFormat(price), "100,000تومان")
    }

    @Test
    fun checkComma() {
        val format = Format(mockContext)
        val price = 10000000
        val commas =
            format.priceFormat(price).length - format.priceFormat(price).replace(",", "").length
        assertEquals(commas, 2)
    }

}