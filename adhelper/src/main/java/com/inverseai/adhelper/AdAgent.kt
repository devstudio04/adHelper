package com.inverseai.adhelper

import android.content.Context
import com.inverseai.adhelper.banner.AdmobBannerAd
import com.inverseai.adhelper.banner.FacebookBannerAd
import com.inverseai.adhelper.interstitial.AdmobInterstitialAd
import com.inverseai.adhelper.interstitial.FacebookInterstitialAd
import com.inverseai.adhelper.manager.AdmobAdManager
import com.inverseai.adhelper.manager.FacebookAdManager
import com.inverseai.adhelper.native.AdmobNativeAd
import com.inverseai.adhelper.native.FacebookNativeAd

class AdAgent(context: Context, private val adNetwork: Int) {

    private val adManager: AdManager by lazy {
        if(adNetwork == FAN) FacebookAdManager() else AdmobAdManager()
    }

    val interstitialAd: InterstitialAd by lazy {
        if(adNetwork == FAN) FacebookInterstitialAd(context) else AdmobInterstitialAd(context)
    }

    init {
        adManager.initialize(context)
    }

    private val admobNativeAd: NativeAd by lazy {
        AdmobNativeAd(context)
    }

    fun getBannerAd(context: Context, adSize: BannerAd.AdSize): BannerAd {
        return if(adNetwork == FAN) FacebookBannerAd(adSize) else AdmobBannerAd(context, adSize)
    }

    fun getNativeAd(context: Context): NativeAd {
        return if(adNetwork == FAN) FacebookNativeAd() else admobNativeAd
    }

    companion object {
        const val FAN = 0
        const val ADMOB = 1
    }
}