package ir.rezarasoulzadeh.digikala.view.activity

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.fragment.FragmentOne
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*


class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        CustomToolbar(this, basket = false, search = false, title = true, digikala = false, back = true, menu = false)

        customToolbar.titleTextView.text = "دسته بندی محصولات"

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

//        (activity.customToolbar.parent as AppBarLayout).targetElevation = 0f

        val stateListAnimator = StateListAnimator()
        stateListAnimator.addState(IntArray(0), ObjectAnimator.ofFloat(0f))
        (this.customToolbar.parent as AppBarLayout).stateListAnimator = stateListAnimator

        val viewPager = findViewById<ViewPager>(R.id.pager)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // Add Fragments to adapter one by one
        // Add Fragments to adapter one by one
        adapter.addFragment(FragmentOne(), "FRAG1")
        adapter.addFragment(FragmentOne(), "FRAG2")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")
        adapter.addFragment(FragmentOne(), "FRAG3")

        viewPager.adapter = adapter

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

    }

    internal class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }

}