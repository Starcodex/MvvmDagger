package com.starcodex.mvvmdagger

import android.app.Activity
import android.app.Application
import com.starcodex.mvvmdagger.di.component.AppComponent
import com.starcodex.mvvmdagger.di.component.DaggerAppComponent
import com.starcodex.mvvmdagger.di.module.AppModule
import com.starcodex.mvvmdagger.di.module.network.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class BaseApp : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        inject()
        initRealm()
    }
    lateinit var appComponent: AppComponent

    fun inject(){
        appComponent =DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(applicationContext.getString(R.string.base_url)))
                .build()
        appComponent.inject(this)
    }

    fun initRealm(){
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().build())
    }

    private var mCurrentActivity: Activity? = null
    fun getCurrentActivity(): Activity? {
        return mCurrentActivity
    }

    fun setCurrentActivity(mCurrentActivity: Activity?) {
        this.mCurrentActivity = mCurrentActivity
    }

/*
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent
                .builder()
                .create(this)
                .appModule(AppModule(this))
                .netModule(NetModule(applicationContext.getString(R.string.base_url)))
                .build()
    }*/

}