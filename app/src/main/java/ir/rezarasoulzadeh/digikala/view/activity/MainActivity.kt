package ir.rezarasoulzadeh.digikala.view.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
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
import ir.rezarasoulzadeh.digikala.model.CategoryData
import ir.rezarasoulzadeh.digikala.model.OfferData
import ir.rezarasoulzadeh.digikala.model.Responses
import ir.rezarasoulzadeh.digikala.model.attribute.Data
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.service.utils.Timer
import ir.rezarasoulzadeh.digikala.view.adapter.*
import ir.rezarasoulzadeh.digikala.viewmodel.SearchViewModel
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import ir.rezarasoulzadeh.digikala.viewmodel.TopViewModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var serviceViewModel: ServiceViewModel
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var topViewModel: TopViewModel

    lateinit var drawerView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var slider: List<Data>
    lateinit var advertisement: List<Data>
    lateinit var offer: List<OfferData>
    lateinit var category: List<CategoryData>
    lateinit var top: List<Responses>
    lateinit var digital: List<Responses>
    lateinit var fashion: List<Responses>
    lateinit var kitchen: List<Responses>
    lateinit var makeup: List<Responses>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            splashDigikala.visibility = View.GONE
        }, 3000)

        CustomToolbar(
            this,
            basket = true,
            search = true,
            title = false,
            digikala = true,
            back = false,
            menu = true,
            product = false
        )

        Timer().handleCountDownTimer(
            hourCounterTextView,
            minuteCounterTextView,
            secondCounterTextView
        )

        drawerView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        drawerView.setNavigationItemSelectedListener(this)

        serviceViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        searchViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(SearchViewModel::class.java)

        topViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(TopViewModel::class.java)

        serviceViewModel.provideSlider()
        serviceViewModel.sliderLiveData.observe(this, Observer {
            slider = it.data
            mainSlider.sliderAdapter = MainSliderAdapter(slider)
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
            val categoryFirstAdapter = CategoryFirstAdapter(this, category)
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

        // کالای دیجیتال
        topViewModel.provideDigital()
        topViewModel.digitalLiveData.observe(this, Observer {
            digital = it.responses

            val digitalAdapter = DigitalAdapter(digital)
            val digitalRecyclerView = findViewById<RecyclerView>(R.id.digitalRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            digitalRecyclerView.layoutManager = horizontal
            digitalRecyclerView.adapter = digitalAdapter
        })

        // مد و پوشاک
        topViewModel.provideFashion()
        topViewModel.fashionLiveData.observe(this, Observer {
            fashion = it.responses

            val fashionAdapter = DigitalAdapter(fashion)
            val fashionRecyclerView = findViewById<RecyclerView>(R.id.fashionRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            fashionRecyclerView.layoutManager = horizontal
            fashionRecyclerView.adapter = fashionAdapter
        })

        // خانه و آشپزخانه
        topViewModel.provideKitchen()
        topViewModel.kitchenLiveData.observe(this, Observer {
            kitchen = it.responses

            val kitchenAdapter = DigitalAdapter(kitchen)
            val kitchenRecyclerView = findViewById<RecyclerView>(R.id.kitchenRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            kitchenRecyclerView.layoutManager = horizontal
            kitchenRecyclerView.adapter = kitchenAdapter
        })

        // آرایشی و بهداشتی
        topViewModel.provideMakeup()
        topViewModel.makeupLiveData.observe(this, Observer {
            makeup = it.responses

            val makeupAdapter = DigitalAdapter(makeup)
            val makeupRecyclerView = findViewById<RecyclerView>(R.id.makeupRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            makeupRecyclerView.layoutManager = horizontal
            makeupRecyclerView.adapter = makeupAdapter
        })

        mainSlider.startAutoCycle()
        mainSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        mainSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

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
            R.id.menuMostSell -> {
                val intent = Intent(this, ListsActivity::class.java)
                intent.putExtra(getString(R.string.intentTitle), getString(R.string.intentMostSellTitle))
                intent.putExtra(getString(R.string.intentSortTitle), getString(R.string.intentMostSellSortTitle))
                startActivity(intent)
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuOffer -> {
                val intent = Intent(this, ListsActivity::class.java)
                intent.putExtra(getString(R.string.intentTitle), getString(R.string.intentOfferTitle))
                intent.putExtra(getString(R.string.intentSortTitle), getString(R.string.intentOfferSortTitle))
                startActivity(intent)
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuMostView -> {
                val intent = Intent(this, ListsActivity::class.java)
                intent.putExtra(getString(R.string.intentTitle), getString(R.string.intentMostViewTitle))
                intent.putExtra(getString(R.string.intentSortTitle), getString(R.string.intentMostViewSortTitle))
                startActivity(intent)
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuNews -> {
                val intent = Intent(this, ListsActivity::class.java)
                intent.putExtra(getString(R.string.intentTitle), getString(R.string.intentNewsTitle))
                intent.putExtra(getString(R.string.intentSortTitle), getString(R.string.intentNewsSortTitle))
                startActivity(intent)
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
        return false
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(this.drawerView)) {
            drawerLayout.closeDrawer(GravityCompat.END)
        } else {
            super.onBackPressed()
        }
    }

}