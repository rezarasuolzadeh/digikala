package ir.rezarasoulzadeh.digikala.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.service.adapter.SliderAdapterExample
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for hide the action bar when use the navigation drawer
        // we want to go styles.xml and set .NoActionBar

        CustomToolbar(this, basket = true, search = true, title = false, digikala = true, back = false, menu = true)

        drawerView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        splashDigikala.visibility = View.GONE

        drawerView.setNavigationItemSelectedListener(this)

        imageSlider.sliderAdapter = SliderAdapterExample(this)
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
            R.id.menuMostSell -> {
                Toast.makeText(this, "پر فروش ترین ها", Toast.LENGTH_SHORT).show()
            }
            R.id.menuOffer -> {
                Toast.makeText(this, "پیشنهاد ویژه دیجیکالا", Toast.LENGTH_SHORT).show()
            }
            R.id.menuMostView -> {
                Toast.makeText(this, "پر بازدید ترین ها", Toast.LENGTH_SHORT).show()
            }
            R.id.menuNews -> {
                Toast.makeText(this, "جدید ترین ها", Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }

}