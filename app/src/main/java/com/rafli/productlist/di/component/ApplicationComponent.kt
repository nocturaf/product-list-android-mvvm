package com.rafli.productlist.di.component

import android.content.Context
import com.rafli.productlist.ProductListApp
import com.rafli.productlist.data.repository.ProductListRepository
import com.rafli.productlist.data.service.ProductListService
import com.rafli.productlist.di.ApplicationContext
import com.rafli.productlist.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: ProductListApp)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): ProductListService

    fun getProductListRepository(): ProductListRepository
}