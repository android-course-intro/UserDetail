package kz.kyrmyzyanik.userdetail.di.module

import dagger.Module
import dagger.Provides
import kz.kyrmyzyanik.userdetail.data.ApiService.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}
