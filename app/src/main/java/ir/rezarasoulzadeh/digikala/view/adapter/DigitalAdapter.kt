package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.*
import ir.rezarasoulzadeh.digikala.service.utils.Format
import kotlinx.android.synthetic.main.model_most_sell.view.*

class DigitalAdapter(private val digital: List<BottomHit>) : RecyclerView.Adapter<DigitalAdapter.DigitalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigitalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_most_sell, parent, false)
        return DigitalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return digital.size
    }

    override fun onBindViewHolder(holder: DigitalViewHolder, position: Int) {
        holder.bind(digital[position].source)
    }

    inner class DigitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(digital: BottomSource) {
            val format = Format()
            itemView.mostSellImage.setImageURI(Uri.parse(digital.imagePath))
            itemView.mostSellTitle.text = digital.faTitle
            itemView.mostSellPrice.text = format.priceFormat(digital.minPrice)
        }
    }

}