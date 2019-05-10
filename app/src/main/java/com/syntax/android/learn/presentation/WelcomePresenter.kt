package com.syntax.android.learn.presentation

import com.syntax.android.learn.ui.welcome.WelcomeView

interface WelcomePresenter : BasePresenter<WelcomeView> {

  fun viewReady()
}
