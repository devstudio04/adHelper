package com.inverseai.adhelper.interstitial

import android.content.Context
import android.util.Log
import com.inverseai.adhelper.InterstitialAd
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.inverseai.adhelper.BuildConfig
import com.inverseai.adhelper.R

class AdmobInterstitialAd(context: Context) : InterstitialAd {

    private var interstitialAd: com.google.android.gms.ads.InterstitialAd? = null

    private var isAdLoaded: Boolean = false
    private var isAdShowed: Boolean = false
    private var isAdLoadingFailed: Boolean = false

    private val adId: String

    private val MAXIMUM_TRY_LOADING_AD: Int
    private var try_count: Int = 0

    init {
        adId = context.getString(
            context.resources.getIdentifier(
                "admob_interstitial", "string",
                context.applicationContext.packageName
            )
        )
        MAXIMUM_TRY_LOADING_AD = context.resources.getInteger(R.integer.maximum_try_loading_ad)
    }

    inner class InterAdListener(private val context: Context) : AdListener() {

        override fun onAdLoaded() {
            super.onAdLoaded()
            Log.d(TAG, "onAdLoaded: ")
            isAdLoaded = true
            isAdLoadingFailed = false
            isAdShowed = false
            try_count = 0
        }

        override fun onAdClicked() {
            super.onAdClicked()
        }

        override fun onAdImpression() {
            super.onAdImpression()
        }

        override fun onAdLeftApplication() {
            super.onAdLeftApplication()
        }

        override fun onAdFailedToLoad(p0: LoadAdError?) {
            super.onAdFailedToLoad(p0)
            Log.d(TAG, "onAdFailedToLoad: $p0")
            isAdLoaded = false
            isAdLoadingFailed = true
            isAdShowed = false

            if (try_count <= MAXIMUM_TRY_LOADING_AD) {
                try_count++
                loadAd(context)
            }
        }

        override fun onAdClosed() {
            super.onAdClosed()

            isAdLoaded = false
            isAdLoadingFailed = false
            isAdShowed = false

            loadAd(context)
        }

        override fun onAdOpened() {
            super.onAdOpened()

            isAdLoaded = false
            isAdLoadingFailed = false
            isAdShowed = true
        }
    }

    override fun loadAd(context: Context) {
        interstitialAd = com.google.android.gms.ads.InterstitialAd(context)
        interstitialAd?.adUnitId =
            if (BuildConfig.DEBUG) context.resources.getString(R.string.admob_interstitial_id_test) else adId
        interstitialAd?.adListener = InterAdListener(context)
        interstitialAd?.loadAd(AdRequest.Builder().build())
    }

    override fun show(context: Context) {
        interstitialAd?.let {
            Log.d(TAG, "show: showing ad")
            if (it.isLoaded && !isAdShowed) it.show()
        }
    }

    override fun onDestroy(context: Context) {
    }

    companion object {
        private const val TAG = "AdmobInterstitialAd"
    }
}