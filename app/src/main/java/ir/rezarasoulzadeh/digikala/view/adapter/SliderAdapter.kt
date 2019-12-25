package ir.rezarasoulzadeh.digikala.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.attribute.Data

class SliderAdapter(private val slider:List<Data>) :
    SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.model_simage_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val imageUri: Uri = Uri.parse(slider[position].bannerPathMobile)
        viewHolder.imageViewBackground.setImageURI(imageUri)
    }

    override fun getCount(): Int {
        return slider.size
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        var imageViewBackground: SimpleDraweeView = itemView.findViewById(R.id.iv_auto_image_slider)
    }

}