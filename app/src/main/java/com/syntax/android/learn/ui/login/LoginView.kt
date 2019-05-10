package com.syntax.android.learn.ui.login

interface LoginView {

  fun showPasswordError()

  fun showEmailError()

  fun onLoginSuccess()

  fun showLoginError()
}