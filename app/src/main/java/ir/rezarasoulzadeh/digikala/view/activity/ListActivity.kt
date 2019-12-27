package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        CustomToolbar(this, basket = true, search = true, title = true, digikala = false, back = true, menu = false)

        customToolbar.titleTextView.text = intent.getStringExtra("title")
        sortTitle.text = intent.getStringExtra("title")

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

    }

}