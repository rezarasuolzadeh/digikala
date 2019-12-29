package ir.rezarasoulzadeh.digikala.service.utils

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import ir.rezarasoulzadeh.digikala.R
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

/**
 * CUSTOM TOOLBAR
 *
 * use to your activity to below sample:
 * >>> CustomToolbar(activity, false, true, ... , false)
 *
 * in the xml of the activity define "include" tag
 * and in that tag set to below line:
 * >>> layout="@layout/layout_toolbar"
 *
 * then to handle the action of the toolbar buttons use
 * from below sample:
 * >>>  customToolbar.backButton.setOnClickListener {
 *          do anything
 *      }
 */

class CustomToolbar(activity: AppCompatActivity, basket: Boolean, search:Boolean, title:Boolean, digikala:Boolean, back:Boolean, menu:Boolean) {

    init {

        if (basket) activity.customToolbar.basketButton.visibility = View.VISIBLE
        if (search) activity.customToolbar.searchButton.visibility = View.VISIBLE
        if (title) activity.customToolbar.titleTextView.visibility = View.VISIBLE
        if (back) activity.customToolbar.backButton.visibility = View.VISIBLE
        if (menu) activity.customToolbar.menuButton.visibility = View.VISIBLE
        if (digikala) activity.customToolbar.digikalaImage.visibility = View.VISIBLE
    }

}