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
class ForamtTextStoreTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val storeName = "فراسو"
        val storeRate = 82
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productSellWithTitle))).thenReturn("فروش توسط")
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.characterDividerText))).thenReturn("|")
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productShopSatisfyTitle))).thenReturn("رضایت خرید:")
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.characterPercentText))).thenReturn("%")
        assertEquals(format.storeTextFormat(storeName, storeRate), "فروش توسط فراسو | رضایت خرید: 82%")
    }

}