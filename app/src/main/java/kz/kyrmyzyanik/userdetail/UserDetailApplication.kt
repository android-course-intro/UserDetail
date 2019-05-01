package kz.kyrmyzyanik.userdetail

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import kz.kyrmyzyanik.userdetail.di.Injector
import kz.kyrmyzyanik.userdetail.di.component.DaggerApplicationComponent

open class UserDetailApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }
}
