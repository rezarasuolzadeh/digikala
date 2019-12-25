package ir.rezarasoulzadeh.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.rezarasoulzadeh.digikala.model.Advertisement
import ir.rezarasoulzadeh.digikala.model.Banner
import ir.rezarasoulzadeh.digikala.model.Slider
import ir.rezarasoulzadeh.digikala.service.repositories.ServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceViewModel(application: Application) : AndroidViewModel(application) {

    var sliderLiveData = MutableLiveData<Slider>()
    var bannerLiveData = MutableLiveData<Banner>()
    var advertisementLiveData = MutableLiveData<Advertisement>()

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

    fun provideAdvertisment() {
        CoroutineScope(Dispatchers.IO).launch {
            advertisementLiveData.postValue(ServiceRepository.getInstance().provideAdvertisement())
        }
    }

}