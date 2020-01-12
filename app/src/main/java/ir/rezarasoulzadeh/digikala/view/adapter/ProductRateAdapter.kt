package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductRateFactorInfo
import kotlinx.android.synthetic.main.model_product_rate.view.*

class ProductRateAdapter(private val productRate: List<ProductRateFactorInfo>) :
    RecyclerView.Adapter<ProductRateAdapter.ProductRateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRateViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.model_product_rate, parent, false)
        return ProductRateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productRate.size
    }

    override fun onBindViewHolder(holder: ProductRateViewHolder, position: Int) {
        holder.bind(productRate[position])
    }

    inner class ProductRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productRate: ProductRateFactorInfo) {
            itemView.rateTitleTextView.text = productRate.title
            val rate = productRate.rateAverage.toInt()
            itemView.rateProgressBarFirst.progressTintList =
                ColorStateList.valueOf(Color.parseColor("#0A8501"))
            itemView.rateProgressBarSecond.progressTintList =
                ColorStateList.valueOf(Color.parseColor("#0A8501"))
            itemView.rateProgressBarThird.progressTintList =
                ColorStateList.valueOf(Color.parseColor("#0A8501"))
            itemView.rateProgressBarForth.progressTintList =
                ColorStateList.valueOf(Color.parseColor("#0A8501"))
            itemView.rateProgressBarFifth.progressTintList =
                ColorStateList.valueOf(Color.parseColor("#0A8501"))

            itemView.rateProgressBarFirst.progress = 0
            itemView.rateProgressBarSecond.progress = 0
            itemView.rateProgressBarThird.progress = 0
            itemView.rateProgressBarForth.progress = 0
            itemView.rateProgressBarFifth.progress = 0

            when (rate) {
                in 1..20 -> {
                    itemView.rateProgressBarFirst.progress = rate
                }
                in 21..40 -> {
                    itemView.rateProgressBarFirst.progress = 100
                    itemView.rateProgressBarSecond.progress = (rate - 20)
                }
                in 41..60 -> {
                    itemView.rateProgressBarFirst.progress = 100
                    itemView.rateProgressBarSecond.progress = 100
                    itemView.rateProgressBarThird.progress = (rate - 40)
                }
                in 61..80 -> {
                    itemView.rateProgressBarFirst.progress = 100
                    itemView.rateProgressBarSecond.progress = 100
                    itemView.rateProgressBarThird.progress = 100
                    itemView.rateProgressBarForth.progress = (rate - 60)
                }
                in 81..100 -> {
                    itemView.rateProgressBarFirst.progress = 100
                    itemView.rateProgressBarSecond.progress = 100
                    itemView.rateProgressBarThird.progress = 100
                    itemView.rateProgressBarForth.progress = 100
                    itemView.rateProgressBarFifth.progress = (rate - 80)
                }
            }
        }
    }

}