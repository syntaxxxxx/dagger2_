
package com.syntax.android.learn.presentation.implementation

import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.presentation.WelcomePresenter
import com.syntax.android.learn.ui.welcome.WelcomeView
import javax.inject.Inject

class WelcomePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface
) : WelcomePresenter {

  private lateinit var view: WelcomeView

  override fun setView(view: WelcomeView) {
    this.view = view
  }

  override fun viewReady() {
    if (authenticationInterface.getUserId().isNotBlank()) {
      view.startMainScreen()
    }
  }
}