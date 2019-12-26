package ir.rezarasoulzadeh.digikala.view.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.*
import ir.rezarasoulzadeh.digikala.model.attribute.Data
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.adapter.*
import ir.rezarasoulzadeh.digikala.viewmodel.SearchViewModel
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var serviceViewModel: ServiceViewModel
    private lateinit var searchViewModel: SearchViewModel

    lateinit var drawerView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var slider: List<Data>
    lateinit var banner: List<Data>
    lateinit var advertisement: List<Data>
    lateinit var offer: List<OfferData>
    lateinit var category: List<CategoryData>
    lateinit var top: List<Responses>
    lateinit var digital: List<BottomHit>
    lateinit var fashion: List<BottomHit>
    lateinit var kitchen: List<BottomHit>
    lateinit var makeup: List<BottomHit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CustomToolbar(
            this,
            basket = true,
            search = true,
            title = false,
            digikala = true,
            back = false,
            menu = true
        )

        drawerView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        splashDigikala.visibility = View.GONE

        drawerView.setNavigationItemSelectedListener(this)

        serviceViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        searchViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(SearchViewModel::class.java)


        serviceViewModel.provideSlider()
        serviceViewModel.sliderLiveData.observe(this, Observer {
            slider = it.data
            imageSlider.sliderAdapter = SliderAdapter(slider)
        })

        serviceViewModel.provideBanner()
        serviceViewModel.bannerLiveData.observe(this, Observer {
            bannerFirst.setImageURI(Uri.parse(it.data[1][0].bannerPathMobile))
            bannerSecond.setImageURI(Uri.parse(it.data[0][0].bannerPathMobile))
            bannerThird.setImageURI(Uri.parse(it.data[0][1].bannerPathMobile))
            bannerFourth.setImageURI(Uri.parse(it.data[1][1].bannerPathMobile))
            bannerFifth.setImageURI(Uri.parse(it.data[0][2].bannerPathMobile))
            bannerSixth.setImageURI(Uri.parse(it.data[0][3].bannerPathMobile))
        })

        serviceViewModel.provideAdvertisement()
        serviceViewModel.advertisementLiveData.observe(this, Observer {
            advertisement = it.data
            advertisementTop.setImageURI(Uri.parse(advertisement[0].bannerPathMobile))
            advertisementBottom.setImageURI(Uri.parse(advertisement[1].bannerPathMobile))
        })

        serviceViewModel.provideOffer()
        serviceViewModel.offerLiveData.observe(this, Observer {
            offer = it.data
            val offerAdapter = OfferAdapter(offer)
            val offerRecyclerView = findViewById<RecyclerView>(R.id.offerRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            offerRecyclerView.layoutManager = horizontal
            offerRecyclerView.adapter = offerAdapter
        })

        serviceViewModel.provideCategory()
        serviceViewModel.categoryLiveData.observe(this, Observer {
            category = it.data
            val categoryFirstAdapter = CategoryFirstAdapter(category)
            val categoryFirstRecyclerView =
                findViewById<RecyclerView>(R.id.categoryFirstRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            categoryFirstRecyclerView.layoutManager = horizontal
            categoryFirstRecyclerView.adapter = categoryFirstAdapter
        })

        searchViewModel.provideTop()
        searchViewModel.topLiveData.observe(this, Observer {
            top = it.responses

            val mostSellAdapter = MostSellAdapter(top)
            val mostSellRecyclerView = findViewById<RecyclerView>(R.id.mostSellRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            mostSellRecyclerView.layoutManager = horizontal
            mostSellRecyclerView.adapter = mostSellAdapter

            val newsAdapter = NewsAdapter(top)
            val newsRecyclerView = findViewById<RecyclerView>(R.id.newsRecyclerView)
            val newshorizontal =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            newsRecyclerView.layoutManager = newshorizontal
            newsRecyclerView.adapter = newsAdapter
        })

        searchViewModel.provideDigital()
        searchViewModel.digitalLiveData.observe(this, Observer {
            digital = it.hits.hits

            val digitalAdapter = DigitalAdapter(digital)
            val digitalRecyclerView = findViewById<RecyclerView>(R.id.digitalRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            digitalRecyclerView.layoutManager = horizontal
            digitalRecyclerView.adapter = digitalAdapter
        })

        searchViewModel.provideFashion()
        searchViewModel.fashionLiveData.observe(this, Observer {
            fashion = it.hits.hits

            val fashionAdapter = FashionAdapter(fashion)
            val fashionRecyclerView = findViewById<RecyclerView>(R.id.fashionRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            fashionRecyclerView.layoutManager = horizontal
            fashionRecyclerView.adapter = fashionAdapter
        })

        searchViewModel.provideKitchen()
        searchViewModel.kitchenLiveData.observe(this, Observer {
            kitchen = it.hits.hits

            val kitchenAdapter = KitchenAdapter(kitchen)
            val kitchenRecyclerView = findViewById<RecyclerView>(R.id.kitchenRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            kitchenRecyclerView.layoutManager = horizontal
            kitchenRecyclerView.adapter = kitchenAdapter
        })

        searchViewModel.provideMakeup()
        searchViewModel.makeupLiveData.observe(this, Observer {
            makeup = it.hits.hits

            val makeupAdapter = MakeupAdapter(makeup)
            val makeupRecyclerView = findViewById<RecyclerView>(R.id.makeupRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            makeupRecyclerView.layoutManager = horizontal
            makeupRecyclerView.adapter = makeupAdapter
            splashDigikala.visibility = View.GONE
        })

        imageSlider.startAutoCycle()
        imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

        customToolbar.menuButton.setOnClickListener {
            drawerLayout.openDrawer(drawerView)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuHome -> {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuCategory -> {
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
        return false
    }

}