package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductConfigColor
import kotlinx.android.synthetic.main.model_product_colour.view.*

class ProductColourAdapter(private val productColour: List<ProductConfigColor>) :
    RecyclerView.Adapter<ProductColourAdapter.ProductColourViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductColourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_product_colour, parent, false)
        return ProductColourViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productColour.size
    }

    override fun onBindViewHolder(holder: ProductColourViewHolder, position: Int) {
        holder.bind(productColour[position])
    }

    inner class ProductColourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productColour: ProductConfigColor) {
            itemView.colourView.backgroundTintList = ColorStateList.valueOf(Color.parseColor(productColour.code))
            itemView.colourTextView.text = productColour.title
        }
    }

}