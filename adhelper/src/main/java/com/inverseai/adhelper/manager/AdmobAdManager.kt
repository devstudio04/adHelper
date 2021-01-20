package com.inverseai.adhelper.manager

import android.content.Context
import com.inverseai.adhelper.AdManager
import com.google.android.gms.ads.MobileAds

class AdmobAdManager: AdManager {

    override fun initialize(context: Context) {
        MobileAds.initialize(context)
    }
}