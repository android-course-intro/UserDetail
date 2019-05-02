package kz.kyrmyzyanik.userdetail.ui.user

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.kyrmyzyanik.userdetail.data.dao.UserDao
import kz.kyrmyzyanik.userdetail.data.gateway.UsersGatewayImpl
import kz.kyrmyzyanik.userdetail.data.gateway.ApiResponse
import kz.kyrmyzyanik.userdetail.di.qulifier.BgContext
import kz.kyrmyzyanik.userdetail.di.qulifier.UiContext
import kz.kyrmyzyanik.userdetail.model.User
import kz.kyrmyzyanik.userdetail.util.SingleLiveEvent
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UserViewModel @Inject constructor(private val usersGateway: UsersGatewayImpl,
                                        private val userDao: UserDao,
                                        @UiContext
                                        private val uiContext: CoroutineContext,
                                        @BgContext
                                        private val bgContext: CoroutineContext) : ViewModel() {


    val isProgressBarVisible = ObservableBoolean(false)
    val showErrorToast = SingleLiveEvent<Int>()
    val usersListLiveData = MutableLiveData<List<User>>()

    /**
     * Method requests data from API and returns LiveData.
     */
    fun loadUsers(): LiveData<List<User>> = usersListLiveData.apply {
        if (value == null) {
            requestUsers()
        }
    }

    /**
     * Method requests data from API and checks the status of response.
     */
    private fun requestUsers() = GlobalScope.launch(uiContext) {
        val result = usersGateway.loadUsers()

        when (result) {
            is ApiResponse.Success -> {
//                isProgressBarVisible.set(false)
                val users = withContext(bgContext) {
                    userDao.getUsers()
                }
                usersListLiveData.value = users
            }
            is ApiResponse.Error -> {
//                isProgressBarVisible.set(false)
                showErrorToast.call()
            }
        }

    }
}