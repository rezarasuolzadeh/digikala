package ir.rezarasoulzadeh.digikala.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.rezarasoulzadeh.digikala.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

    }

}
