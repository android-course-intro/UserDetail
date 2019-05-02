package kz.kyrmyzyanik.userdetail.data.gateway

import kotlinx.coroutines.withContext
import kz.kyrmyzyanik.userdetail.data.ApiService
import kz.kyrmyzyanik.userdetail.data.dao.UserDao
import kz.kyrmyzyanik.userdetail.di.qulifier.BgContext
import kz.kyrmyzyanik.userdetail.model.User
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UsersGateway @Inject constructor(private val apiService: ApiService,
                                       private val userDao: UserDao,
                                       @BgContext private val bgContext: CoroutineContext)  {

    suspend fun loadUsers() = withContext(bgContext) {
        try {
            val response = apiService.loadUsers().execute()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    for (item in responseBody) {
                        saveUser(item)
                    }
                    return@withContext ApiResponse.Success
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return@withContext ApiResponse.Error
    }

    private fun saveUser(user: User) {
        userDao.insert(user)
    }
}
