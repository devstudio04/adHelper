package com.inverseai.adhelper.util

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.util.Log

object DeviceUtil {
    val screenWidth: Int
        get() = Resources.getSystem().displayMetrics.widthPixels

    val screenHeight: Int
        get() = Resources.getSystem().displayMetrics.heightPixels

    fun getDeviceScreenHeightDp(context: Context): Float {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.heightPixels / displayMetrics.density
    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().displayMetrics.density).toInt()
    }

    fun isNetworkPresent(context: Context): Boolean {
        var isNetworkAvailable = false
        try {
            val cm = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (cm != null) {
                val netInfo = cm.activeNetworkInfo
                if (netInfo != null) {
                    isNetworkAvailable = netInfo.isConnectedOrConnecting
                }
            }

            // check for wifi also
            if (!isNetworkAvailable) {
                val connec = context.applicationContext
                        .getSystemService(Context.WIFI_SERVICE) as WifiManager
                val wifi = cm.getNetworkInfo(1)?.state
                isNetworkAvailable = (connec.isWifiEnabled
                        && wifi.toString().equals("CONNECTED", ignoreCase = true))
            }
        } catch (ex: Exception) {
            Log.e("Network Avail Error", ex.message!!)
        }
        return isNetworkAvailable
    }
}