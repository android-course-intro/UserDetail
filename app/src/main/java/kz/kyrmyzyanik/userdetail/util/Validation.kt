package kz.kyrmyzyanik.userdetail.util

import java.util.regex.Pattern

fun String.validateEmail(): Boolean {
    return Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z‌​]{2,})$")
        .matcher(this)
        .matches()
}

fun String.validatePwd(): Boolean {
    return isNotEmpty()
}