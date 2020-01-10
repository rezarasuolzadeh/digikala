package ir.rezarasoulzadeh.digikala.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductInfoNavigationSource
import kotlinx.android.synthetic.main.model_category_second.view.*

class ProductCategoryAdapter(private val productCategory: List<ProductInfoNavigationSource>) :
    RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_category_second, parent, false)
        return ProductCategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productCategory.size
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        holder.bind(productCategory[position].title)
    }

    inner class ProductCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.productCategoryTextView.text = text
        }
    }

}