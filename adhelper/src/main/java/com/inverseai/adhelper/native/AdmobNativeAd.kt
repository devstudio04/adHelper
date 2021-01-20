package com.inverseai.adhelper.native

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.android.gms.ads.*
import com.inverseai.adhelper.NativeAd
import com.google.android.gms.ads.formats.UnifiedNativeAd
import com.inverseai.adhelper.BuildConfig
import com.inverseai.adhelper.R
import com.inverseai.adhelper.nativeTemplates.NativeTemplateStyle
import com.inverseai.adhelper.nativeTemplates.TemplateView
import com.inverseai.adhelper.util.DeviceUtil
import java.util.*

class AdmobNativeAd(context: Context) : NativeAd {

    private val admobNativeId: String

    init {
        admobNativeId = context.getString(
            context.resources.getIdentifier(
                "admob_native", "string",
                context.applicationContext.packageName
            )
        )

        loadNativeAds(context)
    }

    override fun loadAndShow(context: Context, container: ViewGroup) {
        Log.d(TAG, "loadAndShow: ")
        populateNativeAd(context, container, native_height_type)
    }

    override fun onDestroy(context: Context) {
    }

    private val native_height_type = TYPE_SMALL_TEMPLATE_2
    var admobNativeAds: ArrayList<UnifiedNativeAd>? = null
        private set
    private var mAdLoader: AdLoader? = null
    var isAdmobNativeReady = false
        private set

    fun populateNativeAd(context: Context, viewHolder: ViewGroup, heightType: Int) {
        Log.d(TAG, "populateNativeAd: $heightType")
        if (null != admobNativeAds && admobNativeAds!!.size > 0) {
            val unifiedNativeAd = getRandomElement(admobNativeAds!!)
            Log.d(TAG, "populateNativeAd:unified $unifiedNativeAd")
            populateAdmobNativeAd(context, viewHolder, unifiedNativeAd, heightType)
        } else {
            if (DeviceUtil.isNetworkPresent(context)) {
                val builder = AdLoader.Builder(
                    context
                    ,
                    if (BuildConfig.DEBUG) context.resources.getString(R.string.admob_native_id_test) else admobNativeId
                )
                    .forUnifiedNativeAd { unifiedNativeAd ->
                        populateAdmobNativeAd(
                            context,
                            viewHolder,
                            unifiedNativeAd,
                            heightType
                        )
                    }
                builder.build().loadAd(AdRequest.Builder().build())
            } else {
                viewHolder.visibility = View.GONE
            }
        }
    }

    val isAdmobNativeAdLoading: Boolean
        get() = mAdLoader != null && mAdLoader!!.isLoading

    private fun loadNativeAds(context: Context) {
        Log.d(TAG, "loadNativeAds: ")
        if (admobNativeAds == null) admobNativeAds = ArrayList()
        if (!admobNativeAds!!.isEmpty()) return
        isAdmobNativeReady = false
        mAdLoader = AdLoader.Builder(
            context,
            if (BuildConfig.DEBUG) context.resources.getString(R.string.admob_native_id_test) else admobNativeId
        ).forUnifiedNativeAd(object :
            UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
            override fun onUnifiedNativeAdLoaded(unifiedNativeAd: UnifiedNativeAd) {
                Log.d(TAG, "onUnifiedNativeAdLoaded: ")
                admobNativeAds!!.add(unifiedNativeAd)
                if (!mAdLoader!!.isLoading) {
                    isAdmobNativeReady = true
                }
            }
        }).withAdListener(object : AdListener() {
            override fun onAdFailedToLoad(p0: LoadAdError?) {
                super.onAdFailedToLoad(p0)
                Log.d(TAG, "onAdFailedToLoad:101 ${p0?.message}")
                if (!mAdLoader!!.isLoading) {
                    isAdmobNativeReady = true
                }
            }

            override fun onAdClicked() {
                super.onAdClicked()
            }
        }).build()
        mAdLoader?.loadAd(
            AdRequest.Builder().build()
        )
    }

    private fun populateAdmobNativeAd(
        mActivity: Context?,
        layout: ViewGroup,
        unifiedNativeAd: UnifiedNativeAd,
        nativeHeightType: Int
    ) {
        Log.d(TAG, "populateAdmobNativeAd: 126")
        try {
            layout.findViewById<ProgressBar>(R.id.adProgress).visibility = View.GONE
        } catch (e: Exception) {
        }
        var nativeAdContainer: ViewGroup? = null
        try {
            nativeAdContainer = layout.findViewById(R.id.adFrameLayout)
            nativeAdContainer.removeAllViews()
        } catch (e: Exception) {
            nativeAdContainer = layout
            nativeAdContainer.removeAllViews()
        }
        val styles = NativeTemplateStyle.Builder()
            .withMainBackgroundColor(ColorDrawable(-0x1)).build()
        val mTemplateView = TemplateView(mActivity)
        mTemplateView.setTemplateView(nativeHeightType)
        nativeAdContainer!!.addView(mTemplateView)
        mTemplateView.populateView()
        mTemplateView.setStyles(styles)
        mTemplateView.setNativeAd(unifiedNativeAd)
        val mLayoutParams = mTemplateView.layoutParams
        mLayoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
    }

    // Function select an element base on index
    // and return an element
    private fun getRandomElement(list: ArrayList<UnifiedNativeAd>): UnifiedNativeAd {
        val rand = Random()
        return list[rand.nextInt(list.size)]
    }

    companion object {
        private const val TAG = "AdmobNativeAd"
        const val TYPE_MEDIUM_TEMPLATE = 111
        const val TYPE_MEDIUM_TEMPLATE_2 = 222
        const val TYPE_SMALL_TEMPLATE_1 = 0
        const val TYPE_SMALL_TEMPLATE_2 = 2
        const val TYPE_SMALL_TEMPLATE_3 = 1
        const val NUMBER_OF_ADS = 3
    }
}