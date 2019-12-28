package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.rezarasoulzadeh.digikala.R

class ProductSliderAdapter(private val slider:List<String>) :
    SliderViewAdapter<ProductSliderAdapter.ProductSliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ProductSliderViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.model_image_slider, null)
        return ProductSliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: ProductSliderViewHolder, position: Int) {
        val imageUri: Uri = Uri.parse(slider[position])
        viewHolder.imageViewBackground.setImageURI(imageUri)
    }

    override fun getCount(): Int {
        return 4
    }

    inner class ProductSliderViewHolder(itemView: View) : ViewHolder(itemView) {
        var imageViewBackground: SimpleDraweeView = itemView.findViewById(R.id.sliderImage)
    }

}