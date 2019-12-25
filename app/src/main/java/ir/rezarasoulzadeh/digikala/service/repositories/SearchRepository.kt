package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.interfaces.TopDao
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

    companion object {
        @JvmStatic
        fun getInstance(): SearchRepository {
            return SearchRepository()
        }
    }

}