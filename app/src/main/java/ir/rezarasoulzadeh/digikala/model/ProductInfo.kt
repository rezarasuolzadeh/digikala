package ir.rezarasoulzadeh.digikala.model
import com.google.gson.annotations.SerializedName


data class ProductInfo(
    @SerializedName("Data")
    val `data`: ProductInfoData = ProductInfoData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductInfoData(
    @SerializedName("Brand")
    val brand: ProductInfoBrand = ProductInfoBrand(),
    @SerializedName("CategoryId")
    val categoryId: Int = 0, // 1272
    @SerializedName("ContentDescription")
    val contentDescription: Any = Any(), // null
    @SerializedName("ContentDescriptionMode")
    val contentDescriptionMode: Any = Any(), // null
    @SerializedName("Description")
    val description: String = "", // شارژر همراه  انکر  مدل  A1215 Powercore  با ظرفیت اسمی 13000 میلی آمپرساعت و بهره گیری از فناوری شارژ سریع IQ  ابزاری مناسب برای شارژ انواع گوشی های موبایل، تبلت ، دوربین های دیجیتال و دستگاه های پخش موزیک همراه (MP3 Player) و دیگر گجت هاست. باتری این پاور بانک از نوع لیتیومی است و ولتاژ ورودی و خروجی آن 5.0 ولت دارد. همچنین با شدت جریان ورودی 2 آمپر شارژ می شود. اگر دو گوشی موبایل نیازمند به شارژ داشته باشید، این شارژر همراه باوجود 2 درگاه خروجی USB آن  دو را هم زمان شارژ می کند تا در وقت و هزینه تان صرفه جویی شود. بدنه ی این شارژر همراه از جنس پلاستیک ساخته شده است و در برابر خط و خش دوام خوبی دارد. شکل آن مستطیلی است و 96.5 میلی متر طول، 81.2 میلی متر عرض و 22.8 میلی متر ضخامت دارد. نشانگر  LED روی آن  وضعیت شارژ باتری را نشان می دهد، به این صورت که هرکدام از نشانگرها نمایانگر شارژ 25 درصدی آن هستند. با قوی تر شدن پردازنده های گجت های هوشمند در سال های اخیر، مصرف باتری به دغدغه ای مهم تبدیل شده است. یک کاربر گوشی یا تبلت اگر در طی چند ساعت هم از اینترنت استفاده کند، هم فیلم و عکس ببیند، هم به موسیقی گوش کند و هم فیلم برداری و عکس برداری کند، با کم شدن میزان شارژ باتری مواجه خواهد شد. از طرفی یافتن برق برای شارژ همیشه امکان پذیر نیست، هم چنین شارژ شدن دستگاه کاربر را مجبور می کند که گوشی موبایل یا تبلت خود را در کنار پریز برق رها کند یا اگر نیاز به آن داشت در کنار آن بماند. در این شرایط یک شارژر همراه با ظرفیت اسمی مناسب می تواند همه ی این مسائل را برطرف کند. ظرفیت اسمی بالای این شارژر همراه انکر شارژ دستگاه های شما را تا مدت ها تامین خواهد کرد.
    @SerializedName("EnTitle")
    val enTitle: String = "", // Anker A1215 Powercore 13000mAh Power Bank
    @SerializedName("ExistStatus")
    val existStatus: String = "", // Available
    @SerializedName("FaTitle")
    val faTitle: String = "", // شارژر همراه انکر مدل A1215 Powercore ظرفیت 13000 میلی آمپر ساعت
    @SerializedName("FavoriteId")
    val favoriteId: Any = Any(), // null
    @SerializedName("HasNotification")
    val hasNotification: Boolean = false, // false
    @SerializedName("ImagePaths")
    val imagePaths: ProductInfoImagePaths = ProductInfoImagePaths(),
    @SerializedName("IsFake")
    val isFake: Boolean = false, // false
    @SerializedName("IsSpecialOffer")
    val isSpecialOffer: Boolean = false, // true
    @SerializedName("MinPrice")
    val minPrice: Int = 0, // 2190000
    @SerializedName("NavigationSource")
    val navigationSource: List<ProductInfoNavigationSource> = listOf(),
    @SerializedName("NotifierInfo")
    val notifierInfo: Any = Any(), // null
    @SerializedName("pic3DView")
    val pic3DView: Any = Any(), // null
    @SerializedName("ProductId")
    val productId: Int = 0, // 164983
    @SerializedName("Rate")
    val rate: Int = 0, // 87
    @SerializedName("RateCounter")
    val rateCounter: Int = 0, // 1027
    @SerializedName("ReviewSourceObject")
    val reviewSourceObject: ProductInfoReviewSourceObject = ProductInfoReviewSourceObject(),
    @SerializedName("SavedInCurrentUserFavorite")
    val savedInCurrentUserFavorite: Boolean = false, // false
    @SerializedName("ShowType")
    val showType: String = "", // FaTitle
    @SerializedName("trackerData")
    val trackerData: ProductInfoTrackerData = ProductInfoTrackerData(),
    @SerializedName("VideoCount")
    val videoCount: Int = 0 // 0
)

data class ProductInfoBrand(
    @SerializedName("Id")
    val id: Int = 0, // 1742
    @SerializedName("Title")
    val title: String = "" // Anker
)

data class ProductInfoImagePaths(
    @SerializedName("Original")
    val original: String = "", // https://dkstatics-public.digikala.com/digikala-products/1467534.jpg
    @SerializedName("Size110")
    val size110: String = "", // https://dkstatics-public.digikala.com/digikala-products/1467534.jpg?x-oss-process=image/resize,w_110/quality,q_60
    @SerializedName("Size180")
    val size180: String = "", // https://dkstatics-public.digikala.com/digikala-products/1467534.jpg?x-oss-process=image/resize,w_180/quality,q_60
    @SerializedName("Size220")
    val size220: String = "", // https://dkstatics-public.digikala.com/digikala-products/1467534.jpg?x-oss-process=image/resize,w_220/quality,q_60
    @SerializedName("Size70")
    val size70: String = "" // https://dkstatics-public.digikala.com/digikala-products/1467534.jpg?x-oss-process=image/resize,w_70/quality,q_60
)

data class ProductInfoNavigationSource(
    @SerializedName("Position")
    val position: Int = 0, // 3
    @SerializedName("Title")
    val title: String = "", // پاوربانک (شارژر همراه)
    @SerializedName("UrlCode")
    val urlCode: String = "" // /Search/category-power-bank/
)

data class ProductInfoReviewSourceObject(
    @SerializedName("ReviewSource")
    val reviewSource: List<ProductInfoReviewSource> = listOf(),
    @SerializedName("ShortReview")
    val shortReview: String = "" // انکر جزو پرفروش ترین برندها در حوزه ی لوازم جانبی بوده و مدل A1215 Powercore یکی از شارژرهای همراه قدرتمند ساخت این شرکت است. این پاوربانک با 2 درگاه خروجی و یک درگاه ورودی، همراهی مطمئن برای دستگاه های دیجیتال شماست که باتری بیشتر گوشی های هوشمند را با سرعت و امنیت بالا شارژ می کند.
)

data class ProductInfoReviewSource(
    @SerializedName("subsections")
    val subsections: List<ProductInfoSubsection> = listOf(),
    @SerializedName("title")
    val title: String = "" // جمع بندی
)

data class ProductInfoSubsection(
    @SerializedName("image")
    val image: String = "", // https://dkstatics-public.digikala.com/digikala-reviews/1426067.jpg?x-oss-process=image/resize,w_960/quality,q_70
    @SerializedName("qoute")
    val qoute: ProductInfoQoute = ProductInfoQoute(),
    @SerializedName("quote")
    val quote: Any = Any(), // null
    @SerializedName("template")
    val template: String = "", // image
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = "" // متن
)

data class ProductInfoQoute(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = ""
)

data class ProductInfoTrackerData(
    @SerializedName("brand_id")
    val brandId: Int = 0, // 1742
    @SerializedName("category_id")
    val categoryId: Int = 0, // 1272
    @SerializedName("channel")
    val channel: List<Any> = listOf(),
    @SerializedName("page_view")
    val pageView: Boolean = false, // true
    @SerializedName("product_id")
    val productId: Int = 0, // 164983
    @SerializedName("status")
    val status: String = "", // marketable
    @SerializedName("variants")
    val variants: List<Any> = listOf()
)