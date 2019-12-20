package ir.rezarasoulzadeh.digikala.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import ir.rezarasoulzadeh.digikala.R
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for hide the action bar when use the navigation drawer
        // we want to go styles.xml and set .NoActionBar

        drawerView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        splashDigikala.visibility = View.GONE

        drawerView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuHome -> {
                Toast.makeText(this, "خانه", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuCategory -> {
                Toast.makeText(this, "لیست دسته بندی محصولات", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuBasket -> {
                Toast.makeText(this, "سبد خرید", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuMostSell -> {
                Toast.makeText(this, "پر فروش ترین ها", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuOffer -> {
                Toast.makeText(this, "پیشنهاد ویژه دیجیکالا", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuMostView -> {
                Toast.makeText(this, "پر بازدید ترین ها", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuNews -> {
                Toast.makeText(this, "جدید ترین ها", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuSetting -> {
                Toast.makeText(this, "تنظیمات", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuQuestion -> {
                Toast.makeText(this, "سئوالات متداول", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
            R.id.menuAboutUs -> {
                Toast.makeText(this, "درباره ما", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
        return true
    }

}