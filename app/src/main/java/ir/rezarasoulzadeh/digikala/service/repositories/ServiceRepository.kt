package ir.rezarasoulzadeh.digikala.service.repositories

import ir.rezarasoulzadeh.digikala.interfaces.*
import ir.rezarasoulzadeh.digikala.model.*
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
                    .getBanner(/*0*//*, 0*/)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    fun provideTop(category: Int): Top? {
        var response: Response<Top>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(BottomDao::class.java)
                    .getTop("c${category}")
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

    fun provideOffer(): Offer? {
        var response: Response<Offer>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(OfferDao::class.java)
                    .getOffer()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    fun provideCategory(): Category? {
        var response: Response<Category>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(CategoryDao::class.java)
                    .getCategory()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    fun provideProductAlbum(productId: Int): ProductAlbum? {
        var response: Response<ProductAlbum>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(ProductDao::class.java)
                    .getProductAlbum(productId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response!!.body()
    }

    fun provideProductInfo(productId: Int): ProductInfo? {
        var response: Response<ProductInfo>? = null
        runBlocking {
            try {
                response = ServiceRetrofitConfig.retrofit().create(ProductDao::class.java)
                    .getProductInfo(productId)
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