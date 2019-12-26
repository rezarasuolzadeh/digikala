package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.interfaces.BottomDao
import ir.rezarasoulzadeh.digikala.interfaces.TopDao
import ir.rezarasoulzadeh.digikala.model.Bottom
import ir.rezarasoulzadeh.digikala.model.Top
import ir.rezarasoulzadeh.digikala.service.config.SearchRetrofitConfig
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class SearchRepository {

    fun provideTop(): Top? {
        var response: Response<Top>? = null
        runBlocking {
            try {
                response = SearchRetrofitConfig.retrofit().create(TopDao::class.java)
                    .getTop(2)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    fun provideBottom(category: Int): Bottom? {
        var response: Response<Bottom>? = null
        runBlocking {
            try {
                response = SearchRetrofitConfig.retrofit().create(BottomDao::class.java)
                    .getBottom("c${category}", 32, 10, 0, 1)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    companion object {
        @JvmStatic
        fun getInstance(): SearchRepository {
            return SearchRepository()
        }
    }

}