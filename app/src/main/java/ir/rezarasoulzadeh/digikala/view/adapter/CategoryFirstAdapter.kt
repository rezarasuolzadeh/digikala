package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.CategoryData
import ir.rezarasoulzadeh.digikala.view.activity.CategoryActivity
import kotlinx.android.synthetic.main.model_category_first.view.*

class CategoryFirstAdapter(private val context: Context, private val category: List<CategoryData>) :
    RecyclerView.Adapter<CategoryFirstAdapter.CategoryFirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryFirstViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.model_category_first, parent, false)
        return CategoryFirstViewHolder(view)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: CategoryFirstViewHolder, position: Int) {
        holder.bind(category[position].category.title, position)
    }

    inner class CategoryFirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, position: Int) {
            itemView.categoryFirstTitle.text = text

            itemView.setOnClickListener {
                val intent = Intent(context, CategoryActivity::class.java)
                intent.putExtra("position", position)
                context.startActivity(intent)
            }

        }
    }

}