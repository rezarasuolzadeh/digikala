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

class FashionAdapter(private val fashion: List<BottomHit>) : RecyclerView.Adapter<FashionAdapter.FashionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FashionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_most_sell, parent, false)
        return FashionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fashion.size
    }

    override fun onBindViewHolder(holder: FashionViewHolder, position: Int) {
        holder.bind(fashion[position].source)
    }

    inner class FashionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fashion: BottomSource) {
            val format = Format()
            itemView.mostSellImage.setImageURI(Uri.parse(fashion.imagePath))
            itemView.mostSellTitle.text = fashion.faTitle
            itemView.mostSellPrice.text = format.priceFormat(fashion.minPrice)
        }
    }

}