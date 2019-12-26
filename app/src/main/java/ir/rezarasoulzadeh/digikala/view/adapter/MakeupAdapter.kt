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

class MakeupAdapter(private val makeup: List<BottomHit>) : RecyclerView.Adapter<MakeupAdapter.MakeupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_most_sell, parent, false)
        return MakeupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return makeup.size
    }

    override fun onBindViewHolder(holder: MakeupViewHolder, position: Int) {
        holder.bind(makeup[position].source)
    }

    inner class MakeupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(makeup: BottomSource) {
            val format = Format()
            itemView.mostSellImage.setImageURI(Uri.parse(makeup.imagePath))
            itemView.mostSellTitle.text = makeup.faTitle
            itemView.mostSellPrice.text = format.priceFormat(makeup.minPrice)
        }
    }

}