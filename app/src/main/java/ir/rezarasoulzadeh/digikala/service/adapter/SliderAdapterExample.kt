package ir.rezarasoulzadeh.digikala.service.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.rezarasoulzadeh.digikala.R

class SliderAdapterExample(private val context: Context) :
    SliderViewAdapter<SliderAdapterExample.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.model_simage_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val imageUri: Uri = Uri.parse("https://picsum.photos/seed/picsum/200/300")
        viewHolder.imageViewBackground.setImageURI(imageUri)
    }

    override fun getCount(): Int { //slider view count could be dynamic size
        return 4
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        var imageViewBackground: SimpleDraweeView = itemView.findViewById(R.id.iv_auto_image_slider)
    }

}