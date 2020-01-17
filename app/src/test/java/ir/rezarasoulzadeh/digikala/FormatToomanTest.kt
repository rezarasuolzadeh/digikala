package ir.rezarasoulzadeh.digikala

import android.content.Context
import ir.rezarasoulzadeh.digikala.service.utils.Format
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FormatToomanTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val price = 1000000
        assertEquals(format.priceTooman(price), 100000)
    }

}