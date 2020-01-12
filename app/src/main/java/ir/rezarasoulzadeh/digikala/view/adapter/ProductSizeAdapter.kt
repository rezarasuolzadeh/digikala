package ir.rezarasoulzadeh.digikala.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.SizeX
import kotlinx.android.synthetic.main.model_product_size.view.*

class ProductSizeAdapter(private val productSize: List<SizeX>) :
    RecyclerView.Adapter<ProductSizeAdapter.ProductSizeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductSizeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_product_size, parent, false)
        return ProductSizeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productSize.size
    }

    override fun onBindViewHolder(holder: ProductSizeViewHolder, position: Int) {
        holder.bind(productSize[position])
    }

    inner class ProductSizeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productSize: SizeX) {
            itemView.sizeTextView.text = productSize.title
        }
    }

}