package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductAlbumData
import ir.rezarasoulzadeh.digikala.model.ProductInfo
import ir.rezarasoulzadeh.digikala.model.ProductInfoData
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.adapter.ProductSliderAdapter
import ir.rezarasoulzadeh.digikala.viewmodel.ServiceViewModel
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.layout_product_first_card.*
import kotlinx.android.synthetic.main.layout_product_first_card.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*
import java.util.*
import java.util.concurrent.TimeUnit

class ProductActivity : AppCompatActivity() {

    private lateinit var serviceViewModel: ServiceViewModel

    lateinit var productAlbum: List<ProductAlbumData>
    lateinit var productInfo: ProductInfoData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        CustomToolbar(this, basket = true, search = false, title = true, digikala = false, back = true, menu = false)

        handleCountDownTimer()

        customToolbar.titleTextView.text = "گوشی موبایل سامسونگ ..."

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

        val productId = intent.getIntExtra("productId", -1)

        serviceViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ServiceViewModel::class.java)

        serviceViewModel.provideProductAlbum(164983)
        serviceViewModel.productAlbumLiveData.observe(this, Observer {
            productAlbum = it.data
            productFirstCardInclude.productSlider.sliderAdapter = ProductSliderAdapter(productAlbum)
        })

        serviceViewModel.provideProductInfo(164983)
        serviceViewModel.productInfoLiveData.observe(this, Observer {
            productInfo = it.data
            productFaTitleTextView.text = productInfo.faTitle
            productEnTitleTextView.text = productInfo.enTitle
        })

        productFirstCardInclude.productSlider.startAutoCycle()
        productFirstCardInclude.productSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        productFirstCardInclude.productSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

    }

    private fun handleCountDownTimer() {
        val current = Calendar.getInstance(TimeZone.getDefault())
        val nextDate = getNextDay()
        object : CountDownTimer(nextDate.timeInMillis - current.timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                //if 24:00:00 occurs?
                if (hours > 24) {
                    hours %= 24
                }
                productFirstCardInclude.productHourCounterTextView.text = String.format("%02d", hours)
                productFirstCardInclude.productMinuteCounterTextView.text = String.format(
                    "%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    )
                )
                productFirstCardInclude.productSecondCounterTextView.text = String.format(
                    "%02d",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    )
                )
            }

            override fun onFinish() {

            }
        }.start()
    }

    private fun getNextDay(): Calendar {
        return Calendar.getInstance(TimeZone.getDefault()).apply {
            add(Calendar.DAY_OF_MONTH, 1)
            set(
                get(Calendar.YEAR),
                get(Calendar.MONTH),
                get(Calendar.DATE),
                0,
                0,
                0
            )
        }
    }

}