package com.favebiz.android.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kz.kyrmyzyanik.userdetail.data.ApiService.AppDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {
	@Singleton
	@Provides
	fun provideDatabase(context: Context): AppDatabase {
		return Room.databaseBuilder(
				context, AppDatabase::class.java, "userdetail.db").build()
	}

	@Provides
	fun provideUserDao(db: AppDatabase) = db.userDao()
}