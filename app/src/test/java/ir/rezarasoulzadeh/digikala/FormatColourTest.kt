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
class FormatColourTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val colour = 5
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productColourTitle))).thenReturn("رنگ")
        assertEquals(format.colourFormat(colour), "5 رنگ")
    }

}