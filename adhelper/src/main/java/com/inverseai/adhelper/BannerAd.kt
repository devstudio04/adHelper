package com.inverseai.adhelper

import android.content.Context
import android.view.ViewGroup

interface BannerAd {

    enum class AdSize {
        SMART, LARGE, MEDIUM
    }

    fun getAdSize(): Int

    fun loadAd(context: Context, adContainer: ViewGroup)

    fun onDestroy(context: Context)
}