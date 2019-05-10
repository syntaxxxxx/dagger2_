
package com.syntax.android.learn.model

import com.syntax.android.learn.common.arePasswordsSame
import com.syntax.android.learn.common.isEmailValid
import com.syntax.android.learn.common.isUsernameValid

data class RegisterRequest(var name: String = "",
                           var email: String = "",
                           var password: String = "",
                           var repeatPassword: String = "") {

  fun isValid(): Boolean = isUsernameValid(name)
      && isEmailValid(email)
      && arePasswordsSame(password, repeatPassword)
}