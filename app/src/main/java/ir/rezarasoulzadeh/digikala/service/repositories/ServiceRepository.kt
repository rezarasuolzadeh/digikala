package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.interfaces.SliderDao
import ir.rezarasoulzadeh.digikala.model.Slider
import ir.rezarasoulzadeh.digikala.service.config.ServiceRetrofitConfig
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class ServiceRepository {

    fun provideSlider(): Slider? {
        var response: Response<Slider>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(SliderDao::class.java)
                    .getSlider("Slider")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    companion object {
        @JvmStatic
        fun getInstance(): ServiceRepository {
            return ServiceRepository()
        }
    }

}