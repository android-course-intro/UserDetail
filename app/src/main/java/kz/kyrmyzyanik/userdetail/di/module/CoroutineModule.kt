package kz.kyrmyzyanik.userdetail.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kz.kyrmyzyanik.userdetail.di.qulifier.BgContext
import kz.kyrmyzyanik.userdetail.di.qulifier.UiContext
import kotlin.coroutines.CoroutineContext

@Module
object CoroutineModule {
    @Provides
    @UiContext
    @JvmStatic
    fun provideCoroutineUiContext(): CoroutineContext = Dispatchers.Main

    @Provides
    @BgContext
    @JvmStatic
    fun provideCoroutineBgContext(): CoroutineContext = Dispatchers.IO

}
