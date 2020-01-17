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
class FormatRateTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val rate = 87f
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productAsTitle))).thenReturn("از")
        assertEquals(format.rateFormatString(rate), "4.3 از 5")
    }

}