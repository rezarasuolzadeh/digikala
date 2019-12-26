package ir.rezarasoulzadeh.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.rezarasoulzadeh.digikala.model.Bottom
import ir.rezarasoulzadeh.digikala.model.Top
import ir.rezarasoulzadeh.digikala.service.repositories.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    var topLiveData = MutableLiveData<Top>()
    var digitalLiveData = MutableLiveData<Bottom>()
    var fashionLiveData = MutableLiveData<Bottom>()
    var kitchenLiveData = MutableLiveData<Bottom>()
    var makeupLiveData = MutableLiveData<Bottom>()

    fun provideTop() {
        CoroutineScope(Dispatchers.IO).launch {
            topLiveData.postValue(SearchRepository.getInstance().provideTop())
        }
    }

    fun provideDigital() {
        CoroutineScope(Dispatchers.IO).launch {
            digitalLiveData.postValue(SearchRepository.getInstance().provideBottom(5966))
        }
    }

    fun provideFashion() {
        CoroutineScope(Dispatchers.IO).launch {
            fashionLiveData.postValue(SearchRepository.getInstance().provideBottom(8749))
        }
    }

    fun provideKitchen() {
        CoroutineScope(Dispatchers.IO).launch {
            kitchenLiveData.postValue(SearchRepository.getInstance().provideBottom(5967))
        }
    }

    fun provideMakeup() {
        CoroutineScope(Dispatchers.IO).launch {
            makeupLiveData.postValue(SearchRepository.getInstance().provideBottom(5968))
        }
    }

}