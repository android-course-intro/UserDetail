package kz.kyrmyzyanik.userdetail.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.kyrmyzyanik.userdetail.ui.login.LoginActivity

@Suppress("unused")
@Module
interface ActivityModule {
    @ContributesAndroidInjector
    fun contributeLoginActivity(): LoginActivity

}