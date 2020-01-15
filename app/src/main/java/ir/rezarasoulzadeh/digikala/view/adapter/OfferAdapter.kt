package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.OfferData
import ir.rezarasoulzadeh.digikala.service.utils.Format
import ir.rezarasoulzadeh.digikala.view.activity.ProductActivity
import kotlinx.android.synthetic.main.model_offer.view.*

class OfferAdapter(private val offer: List<OfferData>) : RecyclerView.Adapter<OfferAdapter.OfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_offer, parent, false)
        return OfferViewHolder(view)
    }

    override fun getItemCount(): Int {
        return offer.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(offer[position])
    }

    inner class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(offer: OfferData) {
            val format = Format()
            itemView.offerImage.setImageURI(Uri.parse(offer.imagePaths.size220))
            itemView.offerTitle.text = offer.title
            itemView.offerMaxPrice.text = format.priceFormat(offer.price)
            itemView.offerMinPrice.text = format.priceFormat(offer.price - offer.discount)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ProductActivity::class.java)
                intent.putExtra("productId", offer.id)
                itemView.context.startActivity(intent)
            }
        }
    }

}