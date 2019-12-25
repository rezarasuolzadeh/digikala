package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.interfaces.AdvertisementDao
import ir.rezarasoulzadeh.digikala.interfaces.BannerDao
import ir.rezarasoulzadeh.digikala.interfaces.SliderDao
import ir.rezarasoulzadeh.digikala.model.Advertisement
import ir.rezarasoulzadeh.digikala.model.Banner
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

    fun provideBanner(): Banner? {
        var response: Response<Banner>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(BannerDao::class.java)
                    .getBanner(0, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    fun provideAdvertisement(): Advertisement? {
        var response: Response<Advertisement>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(AdvertisementDao::class.java)
                    .getAdvertisement("Advertisement", "null")
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