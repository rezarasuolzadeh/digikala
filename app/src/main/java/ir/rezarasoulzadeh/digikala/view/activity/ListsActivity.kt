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
import ir.rezarasoulzadeh.digikala.model.ListsHit
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.service.utils.RecyclerViewOnVerticalScrollListener
import ir.rezarasoulzadeh.digikala.view.adapter.ListsAdapter
import ir.rezarasoulzadeh.digikala.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.dialog_sort.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ListsActivity : AppCompatActivity(), Observer<List<ListsHit>> {

    private var arrange = 0
    private var sort = 4

    private lateinit var searchViewModel: SearchViewModel

    lateinit var lists: List<ListsHit>

    lateinit var adapter: ListsAdapter

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

        val title = intent.getStringExtra("title")
        val title1 = intent.getStringExtra("sortTitle")

        customToolbar.titleTextView.text = title
        sortTitle.text = title1

        searchViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(SearchViewModel::class.java)

        adapter = ListsAdapter(arrange)
        val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
        if (arrange == 1) {
            val horizontal = GridLayoutManager(this, 2)
            listRecyclerView.layoutManager = horizontal
        } else {
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            listRecyclerView.layoutManager = horizontal
        }
        listRecyclerView.adapter = adapter
        attachListener()


        if (title1 == "پر بازدید ترین") {
            searchViewModel.provideLists(sort, 0, true)
            searchViewModel.listsLiveData.observe(this, this)
        }

        if (title1 == "پر فروش ترین") {
            searchViewModel.provideLists(sort, 0, true)
            searchViewModel.listsLiveData.observe(this, this)
        }

        if (title1 == "جدید ترین") {
            searchViewModel.provideLists(sort, 0, true)
            searchViewModel.listsLiveData.observe(this, this)
        }

        arrangeCard.setOnClickListener {
            arrange++
            arrange %= 3
            when (arrange) {
                0 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                    adapter = ListsAdapter(arrange)
                    val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
                    val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    listRecyclerView.layoutManager = horizontal
                    listRecyclerView.adapter = adapter
                }
                1 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_second)
                    adapter = ListsAdapter(arrange)
                    val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
                    val horizontal = GridLayoutManager(this, 2)
                    listRecyclerView.layoutManager = horizontal
                    listRecyclerView.adapter = adapter
                }
                2 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_third)
                    adapter = ListsAdapter(arrange)
                    val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
                    val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    listRecyclerView.layoutManager = horizontal
                    listRecyclerView.adapter = adapter
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

            if (sortTitle.text == "پر بازدید ترین")
                sortView.mostViewRadioButton.isChecked = true
            if (sortTitle.text == "پر فروش ترین")
                sortView.mostSellRadioButton.isChecked = true
            if (sortTitle.text == "قیمت از زیاد به کم")
                sortView.maxPriceRadioButton.isChecked = true
            if (sortTitle.text == "قیمت از کم به زیاد")
                sortView.minPriceRadioButton.isChecked = true
            if (sortTitle.text == "جدید ترین")
                sortView.newsRadioButton.isChecked = true

            sortView.mostViewRadioButton.setOnClickListener {
                sortTitle.text = "پر بازدید ترین"
                sort = 4
                searchViewModel.provideLists(sort, 0, true)
                searchViewModel.listsLiveData.observe(this, this)
                sortAlertDialog.dismiss()
            }

            sortView.mostSellRadioButton.setOnClickListener {
                sortTitle.text = "پر فروش ترین"
                sort = 7
                searchViewModel.provideLists(sort, 0, true)
                searchViewModel.listsLiveData.observe(this, this)
                sortAlertDialog.dismiss()
            }

            sortView.maxPriceRadioButton.setOnClickListener {
                sortTitle.text = "قیمت از زیاد به کم"
                sort = 10
                searchViewModel.provideLists(sort, 0, true)
                searchViewModel.listsLiveData.observe(this, this)
                sortAlertDialog.dismiss()
            }

            sortView.minPriceRadioButton.setOnClickListener {
                sortTitle.text = "قیمت از کم به زیاد"
                sort = 10
                searchViewModel.provideLists(sort, 0, true)
                searchViewModel.listsLiveData.observe(this, this)
                sortAlertDialog.dismiss()
            }

            sortView.newsRadioButton.setOnClickListener {
                sortTitle.text = "جدید ترین"
                sort = 1
                searchViewModel.provideLists(sort, 0, true)
                searchViewModel.listsLiveData.observe(this, this)
                sortAlertDialog.dismiss()
            }
        }

    }

    override fun onChanged(t: List<ListsHit>?) {
        adapter.lists = t!!
        adapter.notifyDataSetChanged()
    }

    private fun attachListener(){
        listRecyclerView.addOnScrollListener(RecyclerViewOnVerticalScrollListener(
            reachedBottom = {
                if (sortTitle.text == "پر بازدید ترین") {
                    sort = 4
                    searchViewModel.provideLists(sort, 0, false)
                    searchViewModel.listsLiveData.observe(this, this)
                }

                if (sortTitle.text == "پر فروش ترین") {
                    sort = 7
                    searchViewModel.provideLists(sort, 0, false)
                    searchViewModel.listsLiveData.observe(this, this)
                }

                if (sortTitle.text == "قیمت از زیاد به کم") {
                    sort = 10
                    searchViewModel.provideLists(sort, 0, false)
                    searchViewModel.listsLiveData.observe(this, this)
                }

                if (sortTitle.text == "قیمت از کم به زیاد") {
                    sort = 10
                    searchViewModel.provideLists(sort, 0, false)
                    searchViewModel.listsLiveData.observe(this, this)
                }

                if (sortTitle.text == "جدید ترین") {
                    sort = 1
                    searchViewModel.provideLists(sort, 0, false)
                    searchViewModel.listsLiveData.observe(this, this)
                }
            }
        ))
    }
}