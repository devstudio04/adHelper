package com.inverseai.adhelper.banner

import android.content.Context
import android.content.res.Resources
import android.view.ViewGroup
import com.inverseai.adhelper.BannerAd
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.inverseai.adhelper.BuildConfig
import com.inverseai.adhelper.R

class FacebookBannerAd(private val size: BannerAd.AdSize): BannerAd {
    private var adView: AdView? = null

    override fun getAdSize(): Int {
        val height = (convertToFanAdSize().height * Resources.getSystem().displayMetrics.density).toInt()

        return height
    }

    override fun loadAd(context: Context, adContainer: ViewGroup) {
        val adId = context.getString(context.resources.getIdentifier("fan_banner_placement", "string",
                context.applicationContext.packageName))

        adView = AdView(context
                , if(BuildConfig.DEBUG) String.format(context.resources.getString(R.string.facebook_banner_test_format), adId) else adId
                , convertToFanAdSize())

        // Find the Ad Container

        // Add the ad view to your activity layout
        adContainer.addView(adView)
        adView?.loadAd()
    }

    override fun onDestroy(context: Context) {
        adView?.destroy()
    }

    private fun convertToFanAdSize(): AdSize {
        when(size) {
            BannerAd.AdSize.LARGE -> return AdSize.BANNER_HEIGHT_90
            BannerAd.AdSize.MEDIUM -> return AdSize.RECTANGLE_HEIGHT_250
            else -> return AdSize.BANNER_HEIGHT_50
        }
    }
}