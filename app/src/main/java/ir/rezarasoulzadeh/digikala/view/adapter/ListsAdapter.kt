package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ListsHit
import ir.rezarasoulzadeh.digikala.model.ListsHits
import ir.rezarasoulzadeh.digikala.service.utils.Format
import kotlinx.android.synthetic.main.model_lists_first.view.*
import kotlinx.android.synthetic.main.model_lists_second.view.*
import kotlinx.android.synthetic.main.model_lists_third.view.*

class ListsAdapter(private val lists: ListsHits, private val arrange: Int) :
    RecyclerView.Adapter<ListsAdapter.ListOfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfferViewHolder {
        val view : View
        return when(arrange) {
            0 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_first, parent, false)
                ListOfferViewHolder(view)
            }
            1 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_second, parent, false)
                ListOfferViewHolder(view)
            }
            2 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_third, parent, false)
                ListOfferViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_first, parent, false)
                ListOfferViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return lists.hits.size
    }

    override fun onBindViewHolder(holder: ListOfferViewHolder, position: Int) {
        holder.bind(lists.hits[position])
    }

    inner class ListOfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(list: ListsHit) {
            val format = Format()
            when(arrange) {
                0 -> {
                    itemView.listFirstMaxPriceTextView.visibility=View.INVISIBLE
                    itemView.listFirstOfferTag.visibility=View.INVISIBLE
                    itemView.listFirstImageView.setImageURI(Uri.parse(list.source.imagePath))
                    itemView.listFirstFaTitleTextView.text = list.source.faTitle
                    itemView.listFirstEnTitleTextView.text = list.source.enTitle
                    itemView.listFirstMaxPriceTextView.text = format.priceFormat(list.source.minPrice)
                    itemView.listFirstMinPriceTextView.text = format.priceFormat(list.source.minPrice)
                    if(list.source.minPriceList != 0) {
                        itemView.listFirstMaxPriceTextView.text = format.priceFormat(list.source.minPriceList)
                        itemView.listFirstMaxPriceTextView.visibility = View.VISIBLE
                    }
                    if(list.source.isSpecialOffer){
                        itemView.listFirstOfferTag.visibility = View.VISIBLE
                    }
                }
                1 -> {
                    itemView.listSecondMaxPriceTextView.visibility=View.INVISIBLE
                    itemView.listSecondOfferTag.visibility=View.INVISIBLE
                    itemView.listSecondImageView.setImageURI(Uri.parse(list.source.imagePath))
                    itemView.listSecondFaTitleTextView.text = list.source.faTitle
                    itemView.listSecondMaxPriceTextView.text = format.priceFormat(list.source.minPrice)
                    itemView.listSecondMinPriceTextView.text = format.priceFormat(list.source.minPrice)
                    if(list.source.minPriceList != 0) {
                        itemView.listSecondMaxPriceTextView.text = format.priceFormat(list.source.minPriceList)
                        itemView.listSecondMaxPriceTextView.visibility = View.VISIBLE
                    }
                    if(list.source.isSpecialOffer){
                        itemView.listSecondOfferTag.visibility = View.VISIBLE
                    }
                }
                2 -> {
                    itemView.listThirdMaxPriceTextView.visibility=View.INVISIBLE
                    itemView.listThirdOfferTag.visibility=View.INVISIBLE
                    itemView.listThirdImageView.setImageURI(Uri.parse(list.source.imagePath))
                    itemView.listThirdFaTitleTextView.text = list.source.faTitle
                    itemView.listThirdEnTitleTextView.text = list.source.enTitle
                    itemView.listThirdMaxPriceTextView.text = format.priceFormat(list.source.minPrice)
                    itemView.listThirdMinPriceTextView.text = format.priceFormat(list.source.minPrice)
                    if(list.source.minPriceList != 0) {
                        itemView.listThirdMaxPriceTextView.text = format.priceFormat(list.source.minPriceList)
                        itemView.listThirdMaxPriceTextView.visibility = View.VISIBLE
                    }
                    if(list.source.isSpecialOffer){
                        itemView.listThirdOfferTag.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

}