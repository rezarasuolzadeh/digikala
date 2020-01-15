package ir.rezarasoulzadeh.digikala.service.config

import android.app.Application
import com.facebook.cache.disk.DiskCacheConfig
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = ImagePipelineConfig
            .newBuilder(this)
            .setSmallImageDiskCacheConfig(DiskCacheConfig.newBuilder(applicationContext).build())
            .setDiskCacheEnabled(true)
            .setDownsampleEnabled(true)
            .setDiskCacheEnabled(true)
            .build()
        Fresco.initialize(this,config)
    }

}