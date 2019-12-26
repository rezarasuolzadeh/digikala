package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.BottomHit
import ir.rezarasoulzadeh.digikala.model.BottomSource
import ir.rezarasoulzadeh.digikala.service.utils.Format
import kotlinx.android.synthetic.main.model_most_sell.view.*

class KitchenAdapter(private val kitchen: List<BottomHit>) : RecyclerView.Adapter<KitchenAdapter.KitchenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitchenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_most_sell, parent, false)
        return KitchenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kitchen.size
    }

    override fun onBindViewHolder(holder: KitchenViewHolder, position: Int) {
        holder.bind(kitchen[position].source)
    }

    inner class KitchenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(kitchen: BottomSource) {
            val format = Format()
            itemView.mostSellImage.setImageURI(Uri.parse(kitchen.imagePath))
            itemView.mostSellTitle.text = kitchen.faTitle
            itemView.mostSellPrice.text = format.priceFormat(kitchen.minPrice)
        }
    }

}