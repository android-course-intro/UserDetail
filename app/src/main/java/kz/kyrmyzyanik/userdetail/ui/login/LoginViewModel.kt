package kz.kyrmyzyanik.userdetail.ui.login

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.kyrmyzyanik.userdetail.di.qulifier.UiContext
import kz.kyrmyzyanik.userdetail.util.validateEmail
import kz.kyrmyzyanik.userdetail.util.validatePwd
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LoginViewModel @Inject constructor(@UiContext
                                        private val uiContext: CoroutineContext) : ViewModel() {

    private  var email = ""
    private  var pwd =""

    val isLogindEnable = ObservableBoolean(false)

    fun emailTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                email = s.toString()
                validateSend()
            }

            override fun afterTextChanged(s: Editable) {

            }
        }
    }

    fun pwdTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                pwd = s.toString()
                validateSend()
            }

            override fun afterTextChanged(s: Editable) {

            }
        }
    }

    private fun validateSend() {
        isLogindEnable.set(email.validateEmail() && pwd.validatePwd())
    }

}