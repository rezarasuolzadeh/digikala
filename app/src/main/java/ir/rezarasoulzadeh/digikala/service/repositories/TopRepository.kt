package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.interfaces.BottomDao
import ir.rezarasoulzadeh.digikala.model.Top
import ir.rezarasoulzadeh.digikala.service.config.TopRetrofitConfig
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class TopRepository {

    fun provideTop(category: Int): Top? {
        var response: Response<Top>? = null
        runBlocking {
            try {
                response = TopRetrofitConfig.retrofit().create(BottomDao::class.java)
                    .getTop("c${category}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    companion object {
        @JvmStatic
        fun getInstance(): TopRepository {
            return TopRepository()
        }
    }

}