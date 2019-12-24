package ir.rezarasoulzadeh.digikala.model.attribute

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("BannerId")
    val bannerId: String = "", // 26485
    @SerializedName("BannerPathMobile")
    val bannerPathMobile: String = "", // https://dkstatics-public.digikala.com/digikala-adservice-banners/1000016677.jpg
    @SerializedName("BannerPathTablet")
    val bannerPathTablet: String = "", // https://dkstatics-public.digikala.com/digikala-adservice-banners/1000016677.jpg
    @SerializedName("BannerType")
    val bannerType: String = "", // Slider
    @SerializedName("campaignId")
    val campaignId: String = "", // 2272
    @SerializedName("DisplayWeight")
    val displayWeight: Int = 0, // 100
    @SerializedName("EndDateTime")
    val endDateTime: String = "", // 2018-08-08T22:13:02.180Z
    @SerializedName("Height")
    val height: Int = 0, // 0
    @SerializedName("Id")
    val id: String = "", // 26485
    @SerializedName("LinkType")
    val linkType: String = "", // URL
    @SerializedName("LinkValue")
    val linkValue: String = "", // https://www.digikala.com/mag/%d8%b1%d8%a7%d9%87%d9%86%d9%85%d8%a7%db%8c-%d8%ac%d8%a7%d9%85%d8%b9-%d9%81%d8%b9%d8%a7%d9%84-%da%a9%d8%b1%d8%af%d9%86-%d8%b1%d9%85%d8%b2-%d9%be%d9%88%db%8c%d8%a7/?bCode=26485
    @SerializedName("PatternImagePath")
    val patternImagePath: String = "", // https://dkstatics-public.digikala.com/digikala-adservice-banners/1000016677.jpg
    @SerializedName("StartDateTime")
    val startDateTime: String = "", // 2018-08-08T22:13:02.180Z
    @SerializedName("Title")
    val title: String = "", // رمز یکبار مصرف
    @SerializedName("Width")
    val width: Int = 0 // 0
)