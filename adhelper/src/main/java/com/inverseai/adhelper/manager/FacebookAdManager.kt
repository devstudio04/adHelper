package com.inverseai.adhelper.manager

import android.content.Context
import com.inverseai.adhelper.AdManager
import com.facebook.ads.AudienceNetworkAds

class FacebookAdManager: AdManager {

    override fun initialize(context: Context) {
        AudienceNetworkAds.initialize(context)
    }
}