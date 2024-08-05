package com.fullscreenintentmanager

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.app.NotificationManager
import android.content.Context
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class FullScreenIntentManagerModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android

  @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
  @ReactMethod
  fun hasFullScreenIntentPermission(promise: Promise) {
        try {
            val notificationManager = reactApplicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val canUseFullScreenIntent = notificationManager.canUseFullScreenIntent()
            promise.resolve(canUseFullScreenIntent)
        } catch (e: Exception) {
            promise.reject("ERROR_CHECKING_PERMISSION", "Error checking full-screen intent permission", e)
        }
    }

  @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
  @ReactMethod
  fun openFullScreenIntentSettings() {
        Intent(Settings.ACTION_MANAGE_APP_USE_FULL_SCREEN_INTENT).apply {
            data = Uri.parse("package:${reactApplicationContext.packageName}")
        }.also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            reactApplicationContext.startActivity(it)
        }
    }

  companion object {
    const val NAME = "FullScreenIntentManager"
  }
}
