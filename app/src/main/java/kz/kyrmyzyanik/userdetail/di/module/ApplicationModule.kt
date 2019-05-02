package kz.kyrmyzyanik.userdetail.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import kz.kyrmyzyanik.userdetail.UserDetailApplication
import javax.inject.Singleton

@Module
class ApplicationModule(val application: UserDetailApplication) {

    @Provides
    @Singleton
    fun provideApplication(): UserDetailApplication = application

    @Provides
    @Singleton
    fun provideApplicationContext(dataController: UserDetailApplication): Context = dataController
}