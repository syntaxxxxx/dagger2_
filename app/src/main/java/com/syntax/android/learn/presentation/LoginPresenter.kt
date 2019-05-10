package com.syntax.android.learn.presentation

import com.syntax.android.learn.ui.login.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

  fun onLoginTapped()

  fun onEmailChanged(email: String)

  fun onPasswordChanged(password: String)
}