package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductAlbumData
import ir.rezarasoulzadeh.digikala.model.ProductConfigData
import ir.rezarasoulzadeh.digikala.model.ProductInfoData
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.service.utils.Format
import ir.rezarasoulzadeh.digikala.service.utils.Timer
import ir.rezarasoulzadeh.digikala.view.adapter.ProductCategoryAdapter
import ir.rezarasoulzadeh.digikala.view.adapter.ProductSliderAdapter
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.layout_product_fifth_card.view.*
import kotlinx.android.synthetic.main.layout_product_first_card.*
import kotlinx.android.synthetic.main.layout_product_first_card.view.*
import kotlinx.android.synthetic.main.layout_product_fourth_card.view.*
import kotlinx.android.synthetic.main.layout_product_sixth_card.view.*
import kotlinx.android.synthetic.main.layout_product_third_card.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*


class ProductActivity : AppCompatActivity() {

    private lateinit var serviceViewModel: ServiceViewModel

    private lateinit var productAlbum: List<ProductAlbumData>
    private lateinit var productInfo: ProductInfoData
    private lateinit var productConfig: ProductConfigData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        CustomToolbar(
            this,
            basket = false,
            search = false,
            title = true,
            digikala = false,
            back = true,
            menu = false,
            product = true
        )

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

        serviceViewModel.provideProductCOnfig(productId)
        serviceViewModel.productConfigLiveData.observe(this, Observer {
            productConfig = it.data
            productThirdCardInclude.productAllStoreTextView.text =
                Format().storeFormat(productConfig.configNum)
            productThirdCardInclude.productWarrantyTextView.text =
                productConfig.configViewModel.warranty.title

            if (productConfig.configViewModel.seller.fullName == "دیجی\u200Cکالا") {
                productThirdCardInclude.productStoreTextView.text = Format().digikalaTextFormat()
                productThirdCardInclude.productStoreImageView.setImageResource(R.drawable.dk)
            } else {
                productThirdCardInclude.productStoreTextView.text = Format().storeTextFormat(
                    productConfig.configViewModel.seller.fullName,
                    productConfig.configViewModel.sellerRating
                )
                productThirdCardInclude.productStoreImageView.setImageResource(R.drawable.ic_store)
            }

            if (productConfig.configViewModel.discount == 0) {
                productThirdCardInclude.productMinPriceTextView.text =
                    Format().priceFormat(productConfig.configViewModel.price)
            } else {
                productThirdCardInclude.productMaxPriceTextView.visibility = View.VISIBLE
                productThirdCardInclude.productMinPriceTextView.text =
                    Format().priceFormat(productConfig.configViewModel.price - productConfig.configViewModel.discount)
                productThirdCardInclude.productMaxPriceTextView.text =
                    Format().priceFormat(productConfig.configViewModel.price)
            }

        })

        serviceViewModel.provideProductInfo(productId)
        serviceViewModel.productInfoLiveData.observe(this, Observer {
            productInfo = it.data
            productFaTitleTextView.text = productInfo.faTitle
            productEnTitleTextView.text = productInfo.enTitle
            customToolbar.titleTextView.text = productInfo.faTitle
            productFifthCardInclude.productDescriptionTextView.text = productInfo.description
            productSixthCardInclude.productRatingBar.rating =
                Format().rateFormatFloat(productInfo.rate.toFloat())
            productSixthCardInclude.productRateFiveTextView.text =
                Format().rateFormatString(productInfo.rate.toFloat())
            productSixthCardInclude.productVoteTextView.text =
                Format().voteFormat(productInfo.rateCounter)

            val productCategoryAdapter = ProductCategoryAdapter(productInfo.navigationSource)
            val productCategoryRecyclerView =
                findViewById<RecyclerView>(R.id.productCategoryRecyclerView)
            val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            productCategoryRecyclerView.layoutManager = horizontal
            productCategoryRecyclerView.adapter = productCategoryAdapter

            if (productInfo.enTitle == " ") {
                productEnTitleTextView.visibility = View.GONE
            }

            if (productInfo.isSpecialOffer) {
                productFirstCardInclude.productTimerLayout.visibility = View.VISIBLE
                productFirstCardInclude.productOfferTagImage.visibility = View.VISIBLE
                productFirstCardInclude.productBellImageView.visibility = View.GONE
                Timer().handleCountDownTimer(
                    productFirstCardInclude.productHourCounterTextView,
                    productFirstCardInclude.productMinuteCounterTextView,
                    productFirstCardInclude.productSecondCounterTextView
                )
            }

            if (productInfo.description == "") {
                productFifthCardInclude.visibility = View.GONE
            } else {
                productFifthCardInclude.productDescriptionTextView.text = productInfo.description
            }

            if (productInfo.contentDescription == null) {
                productForthCardInclude.visibility = View.GONE
            } else {
                productForthCardInclude.productContentDescriptionTextView.text =
                    productInfo.contentDescription.toString()
            }

        })

        productFifthCardInclude.productDescriptionMoreButton.setOnClickListener {
            if (productFifthCardInclude.productDescriptionMoreButton.text == "ادامه مطلب") {
                productFifthCardInclude.productDescriptionTextView.maxLines = 100
                productFifthCardInclude.productDescriptionMoreButton.text = "بستن"
            } else {
                productFifthCardInclude.productDescriptionTextView.maxLines = 8
                productFifthCardInclude.productDescriptionMoreButton.text = "ادامه مطلب"
            }
        }

        customToolbar.titleTextView.isSelected = true
        productFifthCardInclude.productDescriptionTextView.isSelected = true

    }

}