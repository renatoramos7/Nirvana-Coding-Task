package com.renatoramos.nirvanacodingtask.commons.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

/**
 * Created by renatoramos on 20.03.18.
 */
object MethodsUtils {

        /**
         * Method to verify if is Internet Connected
         * @param context
         * @return boolean
         */
        fun isInternetConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }

        /**
         * Method to create a Toast for after Show in the View.
         * @param context
         * @param toastText
         * @param duration
         * @return Toast
         */
        fun makeTextToast(context: Context, toastText: CharSequence, duration: Int): Toast {
            return Toast.makeText(context, toastText, duration)
        }
}