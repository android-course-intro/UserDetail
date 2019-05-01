package kz.kyrmyzyanik.userdetail.di.component

import android.app.Application
import com.favebiz.android.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kz.kyrmyzyanik.userdetail.UserDetailApplication
import kz.kyrmyzyanik.userdetail.di.module.ActivityModule
import kz.kyrmyzyanik.userdetail.di.module.NetworkModule
import kz.kyrmyzyanik.userdetail.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    AndroidInjectionModule::class,
    ActivityModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    FragmentModule::class,
	DatabaseModule::class])

interface ApplicationComponent : AndroidInjector<UserDetailApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }

}