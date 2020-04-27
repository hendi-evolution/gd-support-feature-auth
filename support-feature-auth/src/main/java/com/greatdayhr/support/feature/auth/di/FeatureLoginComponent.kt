package com.greatdayhr.support.feature.auth.di

import com.greatdayhr.support.core.di.CoreComponent
import com.greatdayhr.support.core.di.scope.FeatureScope
import com.greatdayhr.support.feature.auth.LoginDataManager
import dagger.Component

@Component(
    modules = [FeatureLoginModule::class], dependencies = [CoreComponent::class]
)
@FeatureScope
interface FeatureLoginComponent {
    fun inject(manager: LoginDataManager)
}