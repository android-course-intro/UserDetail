package kz.kyrmyzyanik.userdetail.data.ApiService

import kz.kyrmyzyanik.userdetail.model.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * This interface describes API request methods.
 */
interface ApiService {
    @GET("/users")
    fun loadUsers(): Call<List<User>>
}
