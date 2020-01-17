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
class FormatVoteTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun checkOutput() {
        val format = Format(mockContext)
        val vote = 150
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productFromTitle))).thenReturn("از مجموع")
        Mockito.`when`(mockContext.getString(Matchers.eq(R.string.productAcceptCommentTitle))).thenReturn("رای ثبت شده")
        assertEquals(format.voteFormat(vote), "از مجموع 150 رای ثبت شده")
    }

}