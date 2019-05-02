package kz.kyrmyzyanik.userdetail.ui.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.kyrmyzyanik.userdetail.data.dao.UserDao
import kz.kyrmyzyanik.userdetail.data.gateway.UsersGateway
import kz.kyrmyzyanik.userdetail.di.qulifier.BgContext
import kz.kyrmyzyanik.userdetail.di.qulifier.UiContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailViewModel @Inject constructor(private val usersGateway: UsersGateway,
                                          private val userDao: UserDao,
                                          @UiContext
                                          private val uiContext: CoroutineContext,
                                          @BgContext
                                          private val bgContext: CoroutineContext) : ViewModel() {
    val name = ObservableField<String>()
    val username = ObservableField<String>()
    val email = ObservableField<String>()
    val phone = ObservableField<String>()
    val website = ObservableField<String>()
    val company = ObservableField<String>()
    val address = ObservableField<String>()

    /**
     * Method gets data from DataBase
     */
    fun userById(id: Int) = GlobalScope.launch(uiContext) {
        val user =  withContext(bgContext){
            userDao.getUserByID(id)
        }

        name.set(user.name)
        username.set("username ==> ${user.username}")
        email.set("phone ==> ${user.email}")
        phone.set("username ==> ${user.phone}")
        website.set("website ==> ${user.website}")
        company.set("company ==> ${user.company.name} : !!! ${user.company.catchPhrase} !!! : ${user.company.bs}")
        address.set("address ==> ${user.address.city} ${user.address.zipcode} : ${user.address.suite} - ${user.address.street}")
    }

}