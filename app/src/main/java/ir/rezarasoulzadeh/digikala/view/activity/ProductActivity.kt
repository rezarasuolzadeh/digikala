package ir.rezarasoulzadeh.digikala.view.activity

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.service.utils.CustomToolbar
import ir.rezarasoulzadeh.digikala.view.adapter.ProductSliderAdapter
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*
import java.util.*
import java.util.concurrent.TimeUnit

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        CustomToolbar(this, basket = true, search = false, title = true, digikala = false, back = true, menu = false)

        handleCountDownTimer()

        customToolbar.titleTextView.text = "گوشی موبایل سامسونگ ..."

        customToolbar.backButton.setOnClickListener {
            super.onBackPressed()
        }

        val images = arrayListOf(
            "https://dkstatics-public.digikala.com/digikala-adservice-banners/1000016199.jpg",
            "https://dkstatics-public.digikala.com/digikala-adservice-banners/1000016985.jpg",
            "https://dkstatics-public.digikala.com/digikala-adservice-banners/1000017051.jpg",
            "https://dkstatics-public.digikala.com/digikala-adservice-banners/1000016989.jpg"
        )

        productSlider.sliderAdapter = ProductSliderAdapter(images)

        productSlider.startAutoCycle()
        productSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        productSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

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
                productHourCounterTextView.text = String.format("%02d", hours)
                productMinuteCounterTextView.text = String.format(
                    "%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    )
                )
                productSecondCounterTextView.text = String.format(
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