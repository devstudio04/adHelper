package com.inverseai.adhelper

import android.content.Context
import android.view.ViewGroup

interface NativeAd {

    fun loadAndShow(context: Context, container: ViewGroup)

    fun onDestroy(context: Context)
}