package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        CustomToolbar(this, basket = true, search = false, title = false, digikala = false, back = true, menu = false)

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

    }

}