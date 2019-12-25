package ir.rezarasoulzadeh.digikala.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.attribute.Data
import ir.rezarasoulzadeh.digikala.service.adapter.SliderAdapter
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var viewModel: ServiceViewModel
    lateinit var drawerView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var slider: List<Data>
    lateinit var banner: List<Data>
    lateinit var advertisement: List<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CustomToolbar(this, basket = true, search = true, title = false, digikala = true, back = false, menu = true)

        drawerView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        splashDigikala.visibility = View.GONE

        drawerView.setNavigationItemSelectedListener(this)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        viewModel.provideSlider()
        viewModel.sliderLiveData.observe(this, Observer {
            slider = it.data
            imageSlider.sliderAdapter = SliderAdapter(slider)
        })

        viewModel.provideBanner()
        viewModel.bannerLiveData.observe(this, Observer {
            banner = it.data
        })

        viewModel.provideAdvertisment()
        viewModel.advertisementLiveData.observe(this, Observer {
            advertisement = it.data
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