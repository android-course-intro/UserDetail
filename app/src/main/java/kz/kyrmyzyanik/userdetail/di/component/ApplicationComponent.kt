package kz.kyrmyzyanik.userdetail.di.component

import android.content.Context
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import kz.kyrmyzyanik.userdetail.UserDetailApplication
import kz.kyrmyzyanik.userdetail.di.module.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    CoroutineModule::class,
    NetworkModule::class,
    AndroidInjectionModule::class,
    ActivityModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
	DatabaseModule::class])

interface ApplicationComponent  {

    fun application(): UserDetailApplication

    fun applicationContext(): Context

    fun inject(dataController: UserDetailApplication)
}