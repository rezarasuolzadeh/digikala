package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.OfferData
import ir.rezarasoulzadeh.digikala.service.utils.Format
import kotlinx.android.synthetic.main.model_list_first.view.*

class ListOfferAdapter(private val listOffer: List<OfferData>) : RecyclerView.Adapter<ListOfferAdapter.ListOfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfferViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_list_first, parent, false)
        return ListOfferViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOffer.size
    }

    override fun onBindViewHolder(holder: ListOfferViewHolder, position: Int) {
        holder.bind(listOffer[position])
    }

    inner class ListOfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(offer: OfferData) {
            val format = Format()
            itemView.listFirstImageView.setImageURI(Uri.parse(offer.imagePaths.original))
            itemView.listFirstFaTitleTextView.text = offer.title
            itemView.listFirstMaxPrice.text = format.priceFormat(offer.price)
            itemView.listFirstMinPrice.text = format.priceFormat(offer.price - offer.discount)
        }
    }

}