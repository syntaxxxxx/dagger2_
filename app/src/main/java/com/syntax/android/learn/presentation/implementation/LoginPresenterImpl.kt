package com.syntax.android.learn.presentation.implementation

import com.syntax.android.learn.common.isEmailValid
import com.syntax.android.learn.common.isPasswordValid
import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.model.LoginRequest
import com.syntax.android.learn.presentation.LoginPresenter
import com.syntax.android.learn.ui.login.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface
) : LoginPresenter {

  private lateinit var view: LoginView

  private val loginRequest = LoginRequest()

  override fun setView(view: LoginView) {
    this.view = view
  }

  override fun onLoginTapped() {
    if (loginRequest.isValid()) {
      authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
        if (isSuccess) {
          view.onLoginSuccess()
        } else {
          view.showLoginError()
        }
      }
    }
  }

  override fun onEmailChanged(email: String) {
    loginRequest.email = email

    if (!isEmailValid(email)) {
      view.showEmailError()
    }
  }

  override fun onPasswordChanged(password: String) {
    loginRequest.password = password

    if (!isPasswordValid(password)) {
      view.showPasswordError()
    }
  }
}