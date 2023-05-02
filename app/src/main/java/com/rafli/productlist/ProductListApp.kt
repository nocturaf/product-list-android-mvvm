package com.rafli.productlist

import android.app.Application
import com.rafli.productlist.di.component.ApplicationComponent
import com.rafli.productlist.di.component.DaggerApplicationComponent
import com.rafli.productlist.di.module.ApplicationModule

class ProductListApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}