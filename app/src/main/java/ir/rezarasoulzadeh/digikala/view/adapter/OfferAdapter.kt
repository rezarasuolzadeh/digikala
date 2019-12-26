package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.OfferData
import kotlinx.android.synthetic.main.model_offer.view.*
import java.text.NumberFormat
import java.util.*

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
            itemView.offerImage.setImageURI(Uri.parse(offer.imagePaths.original))
            itemView.offerTitle.text = offer.title
            itemView.offerMaxPrice.text = NumberFormat.getNumberInstance(Locale.US).format(offer.price/10).toString().plus(" تومان")
            itemView.offerMinPrice.text = NumberFormat.getNumberInstance(Locale.US).format((offer.price - offer.discount)/10).toString().plus(" تومان")
        }
    }

}