package ir.rezarasoulzadeh.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.rezarasoulzadeh.digikala.model.Top
import ir.rezarasoulzadeh.digikala.service.repositories.TopRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopViewModel(application: Application) : AndroidViewModel(application) {

    var digitalLiveData = MutableLiveData<Top>()
    var kitchenLiveData = MutableLiveData<Top>()
    var fashionLiveData = MutableLiveData<Top>()
    var makeupLiveData = MutableLiveData<Top>()

    fun provideDigital() {
        CoroutineScope(Dispatchers.IO).launch {
            digitalLiveData.postValue(TopRepository.getInstance().provideTop(4))
        }
    }

    fun provideFashion() {
        CoroutineScope(Dispatchers.IO).launch {
            fashionLiveData.postValue(TopRepository.getInstance().provideTop(8752))
        }
    }

    fun provideKitchen() {
        CoroutineScope(Dispatchers.IO).launch {
            kitchenLiveData.postValue(TopRepository.getInstance().provideTop(6226))
        }
    }

    fun provideMakeup() {
        CoroutineScope(Dispatchers.IO).launch {
            makeupLiveData.postValue(TopRepository.getInstance().provideTop(5968))
        }
    }

}