package com.syntax.android.learn.model

import com.syntax.android.learn.common.isEmailValid
import com.syntax.android.learn.common.isPasswordValid

data class LoginRequest(var email: String = "",
                        var password: String = "") {

  fun isValid() = isEmailValid(email) && isPasswordValid(password)
}