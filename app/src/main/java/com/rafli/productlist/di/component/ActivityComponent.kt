package com.rafli.productlist.di.component

import com.rafli.productlist.di.ActivityScope
import com.rafli.productlist.di.module.ActivityModule
import com.rafli.productlist.ui.activity.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}