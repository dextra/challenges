package com.fastnews.mechanism

import android.content.Context
import android.net.ConnectivityManager

object VerifyNetworkInfo {

    fun isConnected(context: Context): Boolean {
        var isConnected = false
        val activeNetwork = getActiveNetworkInfo(context)
        if (activeNetwork != null) {
            isConnected = activeNetwork.isConnected
        }
        return isConnected
    }

    private fun getActiveNetworkInfo(context: Context): android.net.NetworkInfo? {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo
    }

}
