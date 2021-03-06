package ir.rezarasoulzadeh.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.rezarasoulzadeh.digikala.model.Lists
import ir.rezarasoulzadeh.digikala.model.ListsHit
import ir.rezarasoulzadeh.digikala.model.Top
import ir.rezarasoulzadeh.digikala.service.repositories.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    var topLiveData = MutableLiveData<Top>()
    var listsLiveData = MutableLiveData<Lists>()

    fun provideTop() {
        CoroutineScope(Dispatchers.IO).launch {
            topLiveData.postValue(SearchRepository.getInstance().provideTop())
        }
    }

    fun provideLists(sort: Int, condition: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            listsLiveData.postValue(SearchRepository.getInstance().provideLists(sort, condition))
        }
    }

}