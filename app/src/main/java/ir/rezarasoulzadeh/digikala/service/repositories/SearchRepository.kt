package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.service.config.SearchRetrofitConfig
import ir.rezarasoulzadeh.digikala.interfaces.ListsDao
import ir.rezarasoulzadeh.digikala.interfaces.TopDao
import ir.rezarasoulzadeh.digikala.model.Lists
import ir.rezarasoulzadeh.digikala.model.Top
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

    fun provideLists(sort: Int, page: Int): Lists? {
        var response: Response<Lists>? = null
        runBlocking {
            try {
                response = SearchRetrofitConfig.retrofit().create(ListsDao::class.java)
                    .getLists(4, 2, 16, 0, 1)
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