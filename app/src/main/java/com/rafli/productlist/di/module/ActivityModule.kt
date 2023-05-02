package com.rafli.productlist.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rafli.productlist.data.repository.ProductListRepository
import com.rafli.productlist.di.ActivityContext
import com.rafli.productlist.ui.viewmodel.ProductListViewModel
import com.rafli.productlist.ui.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(productListRepository: ProductListRepository): ProductListViewModel {
        return ViewModelProvider(activity,
            ViewModelFactory(ProductListViewModel::class) {
                ProductListViewModel(productListRepository)
            })[ProductListViewModel::class.java]
    }
}