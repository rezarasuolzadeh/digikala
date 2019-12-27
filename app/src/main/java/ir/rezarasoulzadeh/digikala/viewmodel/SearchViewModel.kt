package ir.rezarasoulzadeh.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.rezarasoulzadeh.digikala.model.Top
import ir.rezarasoulzadeh.digikala.service.repositories.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    var topLiveData = MutableLiveData<Top>()

    fun provideTop() {
        CoroutineScope(Dispatchers.IO).launch {
            topLiveData.postValue(SearchRepository.getInstance().provideTop())
        }
    }

}