package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.*
import ir.rezarasoulzadeh.digikala.service.utils.Format
import ir.rezarasoulzadeh.digikala.view.activity.ProductActivity
import kotlinx.android.synthetic.main.model_most_sell.view.*

class DigitalAdapter(private val digital: List<Responses>) : RecyclerView.Adapter<DigitalAdapter.DigitalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigitalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_most_sell, parent, false)
        return DigitalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return digital[1].hits.hits.size
    }

    override fun onBindViewHolder(holder: DigitalViewHolder, position: Int) {
        holder.bind(digital[1].hits.hits[position].source)
    }

    inner class DigitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(digital: Source) {
            val format = Format(itemView.context)
            itemView.mostSellImage.setImageURI(Uri.parse(digital.imagePath))
            itemView.mostSellTitle.text = digital.faTitle
            itemView.mostSellPrice.text = format.priceFormat(digital.minPrice)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ProductActivity::class.java)
                intent.putExtra(itemView.context.getString(R.string.intentProductId), digital.id)
                itemView.context.startActivity(intent)
            }
        }
    }

}