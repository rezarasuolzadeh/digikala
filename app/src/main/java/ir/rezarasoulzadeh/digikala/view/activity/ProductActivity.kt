package ir.rezarasoulzadeh.digikala.view.activity

import android.content.Intent
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
import ir.rezarasoulzadeh.digikala.model.ProductRateData
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.service.utils.Format
import ir.rezarasoulzadeh.digikala.service.utils.Timer
import ir.rezarasoulzadeh.digikala.view.adapter.*
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


@Suppress("SENSELESS_COMPARISON")
class ProductActivity : AppCompatActivity() {

    private lateinit var serviceViewModel: ServiceViewModel

    private lateinit var productAlbum: List<ProductAlbumData>
    private lateinit var productInfo: ProductInfoData
    private lateinit var productConfig: ProductConfigData
    private lateinit var productRate: ProductRateData

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

        val format = Format(this)

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

        val productId = intent.getIntExtra(getString(R.string.intentProductId), -1)

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

        serviceViewModel.provideProductConfig(productId)
        serviceViewModel.productConfigLiveData.observe(this, Observer {
            productConfig = it.data
            productThirdCardInclude.productAllStoreTextView.text =
                format.storeFormat(productConfig.configNum)
            productThirdCardInclude.productWarrantyTextView.text =
                productConfig.configViewModel.warranty.title

            if (productConfig.configViewModel.seller.fullName == "دیجی\u200Cکالا") {
                productThirdCardInclude.productStoreTextView.text = format.digikalaTextFormat()
                productThirdCardInclude.productStoreImageView.setImageResource(R.drawable.dk)
            } else {
                productThirdCardInclude.productStoreTextView.text = format.storeTextFormat(
                    productConfig.configViewModel.seller.fullName,
                    productConfig.configViewModel.sellerRating
                )
                productThirdCardInclude.productStoreImageView.setImageResource(R.drawable.ic_store)
            }

            if (productConfig.configViewModel.discount == 0) {
                productThirdCardInclude.productMinPriceTextView.text =
                    format.priceFormat(productConfig.configViewModel.price)
            } else {
                productThirdCardInclude.productMaxPriceTextView.visibility = View.VISIBLE
                productThirdCardInclude.productMinPriceTextView.text =
                    format.priceFormat(productConfig.configViewModel.price - productConfig.configViewModel.discount)
                productThirdCardInclude.productMaxPriceTextView.text =
                    format.priceFormat(productConfig.configViewModel.price)
            }

            if (productConfig.configViewModel.color != null) {
                productThirdCardInclude.productColourTextView.text =
                    getString(R.string.productColourTitle)
                productThirdCardInclude.productColourNumTextView.text =
                    format.colourFormat(productConfig.colors.size)
                val productColourAdapter = ProductColourAdapter(productConfig.colors)
                val productColourRecyclerView =
                    findViewById<RecyclerView>(R.id.productColourRecyclerView)
                val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                productColourRecyclerView.layoutManager = horizontal
                productColourRecyclerView.adapter = productColourAdapter
            } else if (productConfig.configViewModel.size != null) {
                productThirdCardInclude.productColourTextView.text =
                    getString(R.string.productSizeTitle)
                productThirdCardInclude.productColourNumTextView.text =
                    format.sizeFormat(productConfig.sizes.size)
                val productColourAdapter = ProductSizeAdapter(productConfig.sizes)
                val productColourRecyclerView =
                    findViewById<RecyclerView>(R.id.productColourRecyclerView)
                val horizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                productColourRecyclerView.layoutManager = horizontal
                productColourRecyclerView.adapter = productColourAdapter
            } else {
                productThirdCardInclude.productColourLayout.visibility = View.GONE
                productThirdCardInclude.productColourRecyclerView.visibility = View.GONE
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
                format.rateFormatFloat(productInfo.rate.toFloat())
            productSixthCardInclude.productRateFiveTextView.text =
                format.rateFormatString(productInfo.rate.toFloat())
            productSixthCardInclude.productVoteTextView.text =
                format.voteFormat(productInfo.rateCounter)

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

        serviceViewModel.provideProductRate(productId)
        serviceViewModel.productRateLiveData.observe(this, Observer {
            productRate = it.data
            val productRateAdapter =
                ProductRateAdapter(productRate.categoryRateInfos[0].rateFactorInfos)
            val productRateRecyclerView =
                findViewById<RecyclerView>(R.id.productRateRecyclerView)
            val vertical = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            productRateRecyclerView.layoutManager = vertical
            productRateRecyclerView.adapter = productRateAdapter
        })

        productFifthCardInclude.productDescriptionMoreButton.setOnClickListener {
            if (productFifthCardInclude.productDescriptionMoreButton.text == getString(R.string.productContinueTitle)) {
                productFifthCardInclude.productDescriptionTextView.maxLines = 100
                productFifthCardInclude.productDescriptionMoreButton.text =
                    getString(R.string.productCloseTitle)
            } else {
                productFifthCardInclude.productDescriptionTextView.maxLines = 8
                productFifthCardInclude.productDescriptionMoreButton.text =
                    getString(R.string.productContinueTitle)
            }
        }

        customToolbar.titleTextView.isSelected = true
        productFifthCardInclude.productDescriptionTextView.isSelected = true

        productFirstCardInclude.productShareButton.setOnClickListener {
            val productShareBody = productInfo.faTitle+"\n"+getString(R.string.productShareDeepLink).plus(productId)
            val productShareIntent = Intent(Intent.ACTION_SEND)
            productShareIntent.type = "text/plain"
            productShareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.productShareSubject))
            productShareIntent.putExtra(Intent.EXTRA_TEXT, productShareBody)
            startActivity(Intent.createChooser(productShareIntent, getString(R.string.productShareTitle)))
        }

    }

}