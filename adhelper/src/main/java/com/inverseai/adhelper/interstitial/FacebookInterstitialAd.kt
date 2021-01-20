package com.inverseai.adhelper.interstitial

import android.content.Context
import com.inverseai.adhelper.InterstitialAd
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAdListener
import com.inverseai.adhelper.BuildConfig
import com.inverseai.adhelper.R

class FacebookInterstitialAd(context: Context): InterstitialAd {

    private var interstitialAd: com.facebook.ads.InterstitialAd? = null

    private var isAdLoaded: Boolean = false
    private var isAdShowed: Boolean = false
    private var isAdLoadingFailed: Boolean = false

    private val adId: String

    private val MAXIMUM_TRY_LOADING_AD: Int
    private var try_count: Int = 0

    init {
        adId = context.getString(context.resources.getIdentifier("fan_interstitial_placement", "string",
                context.applicationContext.packageName))
        MAXIMUM_TRY_LOADING_AD = context.resources.getInteger(R.integer.maximum_try_loading_ad)
    }

    inner class InterAdListener(private val context: Context): InterstitialAdListener {

        override fun onInterstitialDisplayed(ad: Ad) {
            // Interstitial ad displayed callback
            isAdLoaded = false
            isAdLoadingFailed = false
            isAdShowed = true
        }

        override fun onInterstitialDismissed(ad: Ad) {
            // Interstitial dismissed callback

            isAdLoaded = false
            isAdLoadingFailed = false
            isAdShowed = false

            loadAd(context)
        }

        override fun onError(ad: Ad?, adError: AdError) {
            // Ad error callback
            isAdLoaded = false
            isAdLoadingFailed = isAdLoadingFailed
            isAdShowed = false

            if(try_count <= MAXIMUM_TRY_LOADING_AD) {
                try_count++
                loadAd(context)
            }
        }

        override fun onAdLoaded(ad: Ad) {
            // Interstitial ad is loaded and ready to be displayed
            // Show the ad
            isAdLoaded = true
            isAdLoadingFailed = false
            isAdShowed = false
            try_count = 0
        }

        override fun onAdClicked(ad: Ad) {
            // Ad clicked callback
        }

        override fun onLoggingImpression(ad: Ad) {
            // Ad impression logged callback
        }
    }

    override fun loadAd(context: Context) {
        interstitialAd = com.facebook.ads.InterstitialAd(context
                , if(BuildConfig.DEBUG) String.format(context.resources.getString(R.string.facebook_interstitial_test_format), adId) else adId)

        interstitialAd?.loadAd(interstitialAd?.buildLoadAdConfig()?.withAdListener(InterAdListener(context))?.build())
    }

    override fun show(context: Context) {
        interstitialAd?.let {
            if(isAdLoaded && !isAdShowed) it.show()
        }
    }


    override fun onDestroy(context: Context) {
        interstitialAd?.destroy()
    }
}