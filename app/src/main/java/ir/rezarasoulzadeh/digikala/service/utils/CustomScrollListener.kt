package ir.rezarasoulzadeh.digikala.service.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.viewmodel.SearchViewModel

class CustomScrollListener(var viewModel: SearchViewModel, var sort: Int, var condition: Int) : RecyclerView.OnScrollListener() {

    var loading = true
    var pastVisiblesItems: Int = 0
    var visibleItemCount: Int = 0
    var totalItemCount: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (dy > 0) {
            visibleItemCount = recyclerView.layoutManager!!.childCount
            totalItemCount = recyclerView.layoutManager!!.itemCount
            pastVisiblesItems = ((recyclerView.layoutManager!!) as LinearLayoutManager).findFirstVisibleItemPosition()

            if (pastVisiblesItems + visibleItemCount >= totalItemCount && loading) {
                loading = false
                viewModel.provideLists(sort, condition, false)
            }
        } else {
            loading = true
        }
    }

}