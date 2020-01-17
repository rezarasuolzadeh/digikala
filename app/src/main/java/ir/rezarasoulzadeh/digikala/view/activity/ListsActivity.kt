package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.Lists
import ir.rezarasoulzadeh.digikala.model.ListsHits
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.adapter.ListsAdapter
import ir.rezarasoulzadeh.digikala.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.dialog_sort.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ListsActivity : AppCompatActivity(), Observer<Lists> {

    private var arrange = 0
    private var sort = 4

    private lateinit var searchViewModel: SearchViewModel

    lateinit var lists: ListsHits

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        CustomToolbar(
            this,
            basket = true,
            search = true,
            title = true,
            digikala = false,
            back = true,
            menu = false,
            product = false
        )

        customToolbar.titleTextView.text = intent.getStringExtra(getString(R.string.intentTitle))
        sortTitle.text = intent.getStringExtra(getString(R.string.intentSortTitle))

        searchViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(SearchViewModel::class.java)

        searchViewModel.provideLists(sort,  0)
        searchViewModel.listsLiveData.observe(this, this)

        arrangeCard.setOnClickListener {
            arrange++
            arrange %= 3
            when (arrange) {
                0 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                    val listOfferAdapter = ListsAdapter(lists, arrange)
                    val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
                    val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    listRecyclerView.layoutManager = horizontal
                    listRecyclerView.adapter = listOfferAdapter
                }
                1 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_second)
                    val listOfferAdapter = ListsAdapter(lists, arrange)
                    val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
                    val horizontal = GridLayoutManager(this, 2)
                    listRecyclerView.layoutManager = horizontal
                    listRecyclerView.adapter = listOfferAdapter
                }
                2 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_third)
                    val listOfferAdapter = ListsAdapter(lists, arrange)
                    val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
                    val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    listRecyclerView.layoutManager = horizontal
                    listRecyclerView.adapter = listOfferAdapter
                }
            }
        }

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

        sortCard.setOnClickListener {
            val sortView = LayoutInflater.from(this).inflate(R.layout.dialog_sort, null)

            val sortViewBuilder = this.let { it1 -> AlertDialog.Builder(it1).setView(sortView) }

            val sortAlertDialog = sortViewBuilder.show()

            if (sortTitle.text == getString(R.string.sortFirstTypeTitle))
                sortView.mostViewRadioButton.isChecked = true
            if (sortTitle.text == getString(R.string.sortSecondTypeTitle))
                sortView.mostSellRadioButton.isChecked = true
            if (sortTitle.text == getString(R.string.sortThirdTypeTitle))
                sortView.maxPriceRadioButton.isChecked = true
            if (sortTitle.text == getString(R.string.sortFourthTypeTitle))
                sortView.minPriceRadioButton.isChecked = true
            if (sortTitle.text == getString(R.string.sortFifthTypeTitle))
                sortView.newsRadioButton.isChecked = true

            sortView.mostViewRadioButton.setOnClickListener {
                sortTitle.text = getString(R.string.sortFirstTypeTitle)
                sort = 4
                searchViewModel.provideLists(sort, 0)
                arrange = 0
                searchViewModel.listsLiveData.observe(this, this)
                arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                sortAlertDialog.dismiss()
            }

            sortView.mostSellRadioButton.setOnClickListener {
                sortTitle.text = getString(R.string.sortSecondTypeTitle)
                sort = 7
                searchViewModel.provideLists(sort, 0)
                arrange = 0
                searchViewModel.listsLiveData.observe(this, this)
                arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                sortAlertDialog.dismiss()
            }

            sortView.maxPriceRadioButton.setOnClickListener {
                sortTitle.text = getString(R.string.sortThirdTypeTitle)
                sort = 10
                searchViewModel.provideLists(sort, 1)
                searchViewModel.listsLiveData.observe(this, this)
                arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                sortAlertDialog.dismiss()
            }

            sortView.minPriceRadioButton.setOnClickListener {
                sortTitle.text = getString(R.string.sortFourthTypeTitle)
                sort = 10
                searchViewModel.provideLists(sort, 1)
                arrange = 0
                searchViewModel.listsLiveData.observe(this, this)
                arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                sortAlertDialog.dismiss()
            }

            sortView.newsRadioButton.setOnClickListener {
                sortTitle.text = getString(R.string.sortFifthTypeTitle)
                sort = 1
                searchViewModel.provideLists(sort, 0)
                arrange = 0
                searchViewModel.listsLiveData.observe(this, this)
                arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                sortAlertDialog.dismiss()
            }
        }

    }

    override fun onChanged(t: Lists?) {
        lists = t!!.hits
        val listOfferAdapter = ListsAdapter(lists, arrange)
        val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
        val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listRecyclerView.layoutManager = horizontal
        listRecyclerView.adapter = listOfferAdapter
    }

}