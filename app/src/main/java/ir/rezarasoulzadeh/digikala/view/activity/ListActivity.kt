package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.OfferData
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.adapter.ListOfferAdapter
import ir.rezarasoulzadeh.digikala.viewmodel.SearchViewModel
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.dialog_sort.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ListActivity : AppCompatActivity() {

    private var arrange = 0
    private lateinit var serviceViewModel: ServiceViewModel
    private lateinit var searchViewModel: SearchViewModel

    lateinit var offer: List<OfferData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        CustomToolbar(this, basket = true, search = true, title = true, digikala = false, back = true, menu = false)

        customToolbar.titleTextView.text = intent.getStringExtra("title")
        sortTitle.text = intent.getStringExtra("sortTitle")

        serviceViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        searchViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(SearchViewModel::class.java)

        serviceViewModel.provideOffer()
        serviceViewModel.offerLiveData.observe(this, Observer {
            offer = it.data
            val listOfferAdapter = ListOfferAdapter(offer)
            val listRecyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            listRecyclerView.layoutManager = horizontal
            listRecyclerView.adapter = listOfferAdapter
        })

        arrangeCard.setOnClickListener {
            arrange++
            arrange %= 3
            when (arrange) {
                0 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_first)
                }
                1 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_second)
                }
                2 -> {
                    arrangeImage.setImageResource(R.drawable.ic_arrange_third)
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

            if(sortTitle.text == "پر بازدید ترین")
                sortView.mostViewRadioButton.isChecked = true
            if(sortTitle.text == "پر فروش ترین")
                sortView.mostSellRadioButton.isChecked = true
            if(sortTitle.text == "قیمت از زیاد به کم")
                sortView.maxPriceRadioButton.isChecked = true
            if(sortTitle.text == "قیمت از کم به زیاد")
                sortView.minPriceRadioButton.isChecked = true
            if(sortTitle.text == "جدید ترین")
                sortView.newsRadioButton.isChecked = true

            sortView.mostViewRadioButton.setOnClickListener {
                sortTitle.text = "پر بازدید ترین"
                sortAlertDialog.dismiss()
            }

            sortView.mostSellRadioButton.setOnClickListener {
                sortTitle.text = "پر فروش ترین"
                sortAlertDialog.dismiss()
            }

            sortView.maxPriceRadioButton.setOnClickListener {
                sortTitle.text = "قیمت از زیاد به کم"
                sortAlertDialog.dismiss()
            }

            sortView.minPriceRadioButton.setOnClickListener {
                sortTitle.text = "قیمت از کم به زیاد"
                sortAlertDialog.dismiss()
            }

            sortView.newsRadioButton.setOnClickListener {
                sortTitle.text = "جدید ترین"
                sortAlertDialog.dismiss()
            }
        }

    }

}