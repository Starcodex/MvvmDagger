package com.starcodex.mvvmdagger

import android.support.test.InstrumentationRegistry
import com.starcodex.mvvmdagger.di.component.AppComponent
import com.starcodex.mvvmdagger.di.module.AppModule
import it.cosenonjaviste.daggermock.DaggerMock


/**
 * Created by Bonestack on 24/09/2018.
 */
fun espressoDaggerMockRule() = DaggerMock.rule<AppComponent>(AppModule(app)) {
    set { component -> component.inject(app) }
}

val app: BaseApp
    get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as BaseApp