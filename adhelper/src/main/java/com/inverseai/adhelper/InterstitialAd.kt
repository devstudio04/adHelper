package com.inverseai.adhelper

import android.content.Context

interface InterstitialAd {

    fun loadAd(context: Context)

    fun show(context: Context)

    fun onDestroy(context: Context)
}