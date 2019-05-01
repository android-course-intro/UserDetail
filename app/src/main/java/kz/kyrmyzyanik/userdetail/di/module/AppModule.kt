package com.favebiz.android.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kz.kyrmyzyanik.userdetail.di.qulifier.BgContext
import kz.kyrmyzyanik.userdetail.di.qulifier.UiContext
import kotlin.coroutines.CoroutineContext

@Module
object AppModule {
    @Provides
    @UiContext
    @JvmStatic
    fun provideCoroutineUiContext(): CoroutineContext = Dispatchers.Main

    @Provides
    @BgContext
    @JvmStatic
    fun provideCoroutineBgContext(): CoroutineContext = Dispatchers.IO
}