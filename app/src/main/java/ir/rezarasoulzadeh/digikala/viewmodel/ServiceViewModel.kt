package ir.rezarasoulzadeh.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.rezarasoulzadeh.digikala.model.*
import ir.rezarasoulzadeh.digikala.service.repositories.SearchRepository
import ir.rezarasoulzadeh.digikala.service.repositories.ServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceViewModel(application: Application) : AndroidViewModel(application) {

    var sliderLiveData = MutableLiveData<Slider>()
    var bannerLiveData = MutableLiveData<Banner>()
    var advertisementLiveData = MutableLiveData<Advertisement>()
    var offerLiveData = MutableLiveData<Offer>()
    var categoryLiveData = MutableLiveData<Category>()
    var categoriesLiveData = MutableLiveData<Category>()
    var productAlbumLiveData = MutableLiveData<ProductAlbum>()
    var fashionLiveData = MutableLiveData<Top>()
    var kitchenLiveData = MutableLiveData<Top>()
    var makeupLiveData = MutableLiveData<Top>()

    fun provideSlider() {
        CoroutineScope(Dispatchers.IO).launch {
            sliderLiveData.postValue(ServiceRepository.getInstance().provideSlider())
        }
    }

    fun provideBanner() {
        CoroutineScope(Dispatchers.IO).launch {
            bannerLiveData.postValue(ServiceRepository.getInstance().provideBanner())
        }
    }

    fun provideAdvertisement() {
        CoroutineScope(Dispatchers.IO).launch {
            advertisementLiveData.postValue(ServiceRepository.getInstance().provideAdvertisement())
        }
    }

    fun provideOffer() {
        CoroutineScope(Dispatchers.IO).launch {
            offerLiveData.postValue(ServiceRepository.getInstance().provideOffer())
        }
    }

    fun provideCategory() {
        CoroutineScope(Dispatchers.IO).launch {
            categoryLiveData.postValue(ServiceRepository.getInstance().provideCategory())
        }
    }

    fun provideCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            categoriesLiveData.postValue(ServiceRepository.getInstance().provideCategory())
        }
    }

    fun provideProductAlbum(productId : Int) {
        CoroutineScope(Dispatchers.IO).launch {
            productAlbumLiveData.postValue(ServiceRepository.getInstance().provideProductAlbum(productId))
        }
    }

}