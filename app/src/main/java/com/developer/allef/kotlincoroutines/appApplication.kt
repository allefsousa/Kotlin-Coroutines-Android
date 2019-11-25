package com.developer.allef.kotlincoroutines

import android.app.Application
import com.developer.allef.kotlincoroutines.di.myModule
import org.koin.core.context.startKoin

/**
 * @author allef.santos on 2019-09-03
 */
class appApplication :Application(){

    override fun onCreate() {
        super.onCreate()

    }

    override fun onTerminate() {
        super.onTerminate()
    }
}