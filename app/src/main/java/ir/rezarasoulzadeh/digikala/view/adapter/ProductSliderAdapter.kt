package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.ProductAlbumData

class ProductSliderAdapter(private val productAlbum:List<ProductAlbumData>) :
    SliderViewAdapter<ProductSliderAdapter.ProductSliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ProductSliderViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.model_product_image_slider, null)
        return ProductSliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: ProductSliderViewHolder, position: Int) {
        val imageUri: Uri = Uri.parse(productAlbum[position].imagePaths.original)
        viewHolder.imageViewBackground.setImageURI(imageUri)
    }

    override fun getCount(): Int {
        return productAlbum.size
    }

    inner class ProductSliderViewHolder(itemView: View) : ViewHolder(itemView) {
        var imageViewBackground: SimpleDraweeView = itemView.findViewById(R.id.productImageSliderImageVIew)
    }

}