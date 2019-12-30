package ir.rezarasoulzadeh.digikala.view.activity

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.CategoryData
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.adapter.ViewPagerAdapter
import ir.rezarasoulzadeh.digikala.view.fragment.FragmentOne
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class CategoryActivity : AppCompatActivity() {

    private lateinit var serviceViewModel: ServiceViewModel

    lateinit var categories: List<CategoryData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        CustomToolbar(this, basket = false, search = false, title = true, digikala = false, back = true, menu = false)

        customToolbar.titleTextView.text = "دسته بندی محصولات"

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

        val stateListAnimator = StateListAnimator()
        stateListAnimator.addState(IntArray(0), ObjectAnimator.ofFloat(0f))
        (this.customToolbar.parent as AppBarLayout).stateListAnimator = stateListAnimator

        serviceViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        val viewPager = findViewById<ViewPager>(R.id.pager)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        serviceViewModel.provideCategories()
        serviceViewModel.categoriesLiveData.observe(this, Observer {
            categories = it.data
            for(i in categories.indices) {
                adapter.addFragment(FragmentOne(), categories[i].category.title)
            }
            viewPager.adapter = adapter

            val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
            tabLayout.setupWithViewPager(viewPager)
        })

    }

}