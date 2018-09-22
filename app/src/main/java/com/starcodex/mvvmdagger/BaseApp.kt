package com.starcodex.mvvmdagger

import android.app.Activity
import android.app.Application
import com.starcodex.mvvmdagger.di.component.DaggerAppComponent
import com.starcodex.mvvmdagger.di.module.AppModule
import com.starcodex.mvvmdagger.di.module.network.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class BaseApp : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(applicationContext.getString(R.string.base_url)))
                .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}