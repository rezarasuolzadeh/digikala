package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ListsHit
import ir.rezarasoulzadeh.digikala.model.ListsHits
import ir.rezarasoulzadeh.digikala.service.utils.Format
import kotlinx.android.synthetic.main.model_list_colour.view.*
import kotlinx.android.synthetic.main.model_lists_first.view.*
import kotlinx.android.synthetic.main.model_lists_second.view.*
import kotlinx.android.synthetic.main.model_lists_third.view.*

class ListsAdapter(private val arrange: Int) :
    RecyclerView.Adapter<ListsAdapter.ListOfferViewHolder>() {

    var lists: List<ListsHit> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfferViewHolder {
        val view : View
        return when(arrange) {
            0 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_first, parent, false)
                return ListOfferViewHolder(view, parent)
            }
            1 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_second, parent, false)
                return ListOfferViewHolder(view, parent)
            }
            2 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_third, parent, false)
                return ListOfferViewHolder(view, parent)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.model_lists_first, parent, false)
                return ListOfferViewHolder(view, parent)
            }
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ListOfferViewHolder, position: Int) {
        holder.bind(lists[position])
    }

    inner class ListOfferViewHolder(itemView: View, var parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {
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
                    itemView.listThirdOfferTag.visibility=View.INVISIBLE
                    itemView.listThirdImageView.setImageURI(Uri.parse(list.source.imagePath))
                    itemView.listThirdFaTitleTextView.text = list.source.faTitle
                    itemView.listThirdEnTitleTextView.text = list.source.enTitle
                    itemView.listThirdMaxPriceTextView.text = format.priceFormat(list.source.minPrice)
                    itemView.listThirdMinPriceTextView.text = format.priceFormat(list.source.minPrice)
                    // product colours list
                    itemView.listThirdColourLayout.removeAllViews()
                    for (i in list.source.productColorList.indices) {
                        val colour = LayoutInflater.from(itemView.context).inflate(R.layout.model_list_colour, parent, false)
                        colour.colourCircle.backgroundTintList = ColorStateList.valueOf(Color.parseColor(list.source.productColorList[i].colorCode))
                        itemView.listThirdColourLayout.addView(colour)
                    }
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