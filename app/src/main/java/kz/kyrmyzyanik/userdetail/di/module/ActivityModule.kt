package kz.kyrmyzyanik.userdetail.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.kyrmyzyanik.userdetail.ui.detail.DetailActivity
import kz.kyrmyzyanik.userdetail.ui.login.LoginActivity
import kz.kyrmyzyanik.userdetail.ui.user.UsersActivity

@Suppress("unused")
@Module
interface ActivityModule {
    @ContributesAndroidInjector
    fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    fun contributeUsersActivity(): UsersActivity

    @ContributesAndroidInjector
    fun contributeDetailActivity(): DetailActivity

}