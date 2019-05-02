package kz.kyrmyzyanik.userdetail

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kz.kyrmyzyanik.userdetail.di.Injector
import kz.kyrmyzyanik.userdetail.di.component.DaggerApplicationComponent
import kz.kyrmyzyanik.userdetail.di.module.ApplicationModule
import kz.kyrmyzyanik.userdetail.di.module.NetworkModule
import javax.inject.Inject

open class UserDetailApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var instance: UserDetailApplication
            set
    }

    val component by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)

        component.inject(this@UserDetailApplication)
        Injector.init(this)
    }


    override fun activityInjector() = dispatchingAndroidInjector
}
