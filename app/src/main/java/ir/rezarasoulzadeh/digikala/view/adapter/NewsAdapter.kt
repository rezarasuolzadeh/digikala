package ir.rezarasoulzadeh.digikala.view.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.Hit
import ir.rezarasoulzadeh.digikala.model.Responses
import ir.rezarasoulzadeh.digikala.service.utils.Format
import ir.rezarasoulzadeh.digikala.view.activity.ProductActivity
import kotlinx.android.synthetic.main.model_most_sell.view.*

class NewsAdapter(private val news: List<Responses>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_most_sell, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news[1].hits.hits.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[1].hits.hits[position])
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mostSell: Hit) {
            val format = Format()
            itemView.mostSellImage.setImageURI(Uri.parse(mostSell.source.imagePath))
            itemView.mostSellTitle.text = mostSell.source.faTitle
            itemView.mostSellPrice.text = format.priceFormat(mostSell.source.minPrice)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ProductActivity::class.java)
                intent.putExtra("productId", mostSell.id)
                itemView.context.startActivity(intent)
            }
        }
    }

}