package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductAlbumData
import ir.rezarasoulzadeh.digikala.model.ProductInfoData
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.service.utils.Timer
import ir.rezarasoulzadeh.digikala.view.adapter.ProductSliderAdapter
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.layout_product_first_card.*
import kotlinx.android.synthetic.main.layout_product_first_card.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*


class ProductActivity : AppCompatActivity() {

    private lateinit var serviceViewModel: ServiceViewModel

    lateinit var productAlbum: List<ProductAlbumData>
    lateinit var productInfo: ProductInfoData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        CustomToolbar(this, basket = true, search = false, title = true, digikala = false, back = true, menu = false)

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

        val productId = intent.getIntExtra("productId", -1)

        serviceViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        serviceViewModel.provideProductAlbum(productId)
        serviceViewModel.productAlbumLiveData.observe(this, Observer {
            productAlbum = it.data
            productFirstCardInclude.productSlider.sliderAdapter = ProductSliderAdapter(productAlbum)
        })

        productFirstCardInclude.productSlider.startAutoCycle()
        productFirstCardInclude.productSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        productFirstCardInclude.productSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

        serviceViewModel.provideProductInfo(productId)
        serviceViewModel.productInfoLiveData.observe(this, Observer {
            productInfo = it.data
            productFaTitleTextView.text = productInfo.faTitle
            productEnTitleTextView.text = productInfo.enTitle
            customToolbar.titleTextView.text = productInfo.faTitle
            customToolbar.titleTextView.isSelected = true
            if(productInfo.enTitle == " ") {
                productEnTitleTextView.visibility = View.GONE
            }
            if(productInfo.isSpecialOffer) {
                productFirstCardInclude.productTimerLayout.visibility = View.VISIBLE
                productFirstCardInclude.productOfferTagImage.visibility = View.VISIBLE
                productFirstCardInclude.productBellImageView.visibility = View.GONE
                Timer().handleCountDownTimer(
                    productFirstCardInclude.productHourCounterTextView,
                    productFirstCardInclude.productMinuteCounterTextView,
                    productFirstCardInclude.productSecondCounterTextView
                )
            }
        })

    }

}