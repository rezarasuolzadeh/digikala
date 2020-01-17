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
class FormatStoreTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val store = 5
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productStoreNumTitle))).thenReturn("فروشنده و گارانتی برای این کالا وجود دارد")
        assertEquals(format.storeFormat(store), "5 فروشنده و گارانتی برای این کالا وجود دارد")
    }

}