
package com.syntax.android.learn

import android.app.Application
import com.syntax.android.learn.di.AppComponent
import com.syntax.android.learn.di.DaggerAppComponent

class App : Application() {

  companion object {
    lateinit var instance: App
      private set

    val component: AppComponent by lazy { DaggerAppComponent.builder().build() }
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  }
}