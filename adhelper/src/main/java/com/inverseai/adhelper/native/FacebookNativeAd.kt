package com.inverseai.adhelper.native

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import com.inverseai.adhelper.NativeAd
import com.facebook.ads.*
import com.inverseai.adhelper.R

class FacebookNativeAd: NativeAd {

    companion object {

        private const val COLOR_LIGHT_GRAY = -0x6f6b64
        private const val COLOR_DARK_GRAY = -0xb1a99b
        private const val COLOR_CTA_BLUE_BG = -0xbf7f01

        private const val MIN_HEIGHT_DP = 300
        private const val MAX_HEIGHT_DP = 500
        private const val DEFAULT_HEIGHT_DP = 350
        private const val DEFAULT_PROGRESS_DP = 50
    }

    private var nativeAd: com.facebook.ads.NativeAd? = null

    private val layoutHeightDp = MIN_HEIGHT_DP

    private val adBackgroundColor = Color.WHITE
    private val titleColor = COLOR_DARK_GRAY
    private val ctaTextColor = COLOR_CTA_BLUE_BG
    private val contentColor = COLOR_LIGHT_GRAY
    private val ctaBgColor = Color.WHITE

    inner class AdListener(private val context: Context, private val container: ViewGroup): NativeAdListener {
        override fun onAdClicked(p0: Ad?) {
        }

        override fun onMediaDownloaded(p0: Ad?) {
        }

        override fun onError(p0: Ad?, p1: AdError?) {
        }

        override fun onAdLoaded(p0: Ad?) {
            reloadAdContainer(context, container)
        }

        override fun onLoggingImpression(p0: Ad?) {
        }
    }

    override fun loadAndShow(context: Context, container: ViewGroup) {
        createAndLoadNativeAd(context, container)
    }

    override fun onDestroy(context: Context) {
        nativeAd?.destroy()
    }

    private fun createAndLoadNativeAd(context: Context, container: ViewGroup) {
        // Create a native ad request with a unique placement ID
        // (generate your own on the Facebook app settings).
        // Use different ID for each ad placement in your app.

        val adId = context.getString(context.resources.getIdentifier("fan_native_placement", "string",
                context.applicationContext.packageName))

        nativeAd = com.facebook.ads.NativeAd(context,
        if(BuildConfig.DEBUG) String.format(context.resources.getString(R.string.facebook_native_test_format), adId) else adId)

        // Initiate a request to load an ad.
        nativeAd?.let {
            it.loadAd(it.buildLoadAdConfig().withAdListener(AdListener(context, container)).build())
        }
    }

    private fun reloadAdContainer(context: Context, nativeAdContainer: ViewGroup) {
        val activity = context
        if (activity != null && nativeAd != null && nativeAd!!.isAdLoaded) {
            nativeAdContainer!!.removeAllViews()

            // Create a NativeAdViewAttributes object and set the attributes
            val attributes =
                    NativeAdViewAttributes(context)
                            .setBackgroundColor(adBackgroundColor)
                            .setTitleTextColor(titleColor)
                            .setDescriptionTextColor(contentColor)
                            .setButtonBorderColor(ctaTextColor)
                            .setButtonTextColor(ctaTextColor)
                            .setButtonColor(ctaBgColor)

            // Use NativeAdView.render to generate the ad View
            val adView = NativeAdView.render(activity, nativeAd!!, attributes)

            nativeAdContainer!!.addView(
                    adView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0))
            updateAdViewParams(adView)
        }
    }

    private fun updateAdViewParams(adView: View) {
        if (adView == null) {
            return
        }
        val params = adView!!.layoutParams
        params.height = (Resources.getSystem().displayMetrics.density * layoutHeightDp).toInt()
        adView!!.layoutParams = params
        adView!!.requestLayout()
    }
}