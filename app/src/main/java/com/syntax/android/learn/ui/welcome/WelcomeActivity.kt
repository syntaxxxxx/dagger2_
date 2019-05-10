package com.syntax.android.learn.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.android.learn.R
import com.syntax.android.learn.common.onClick
import com.syntax.android.learn.ui.login.LoginActivity
import com.syntax.android.learn.ui.main.MainActivity
import com.syntax.android.learn.ui.register.RegisterActivity
import com.syntax.android.learn.welcomePresenter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), WelcomeView {

  private val presenter by lazy { welcomePresenter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_welcome)
    presenter.setView(this)

    presenter.viewReady()

    registerButton.onClick { startActivity(Intent(this, RegisterActivity::class.java)) }
    loginButton.onClick { startActivity(Intent(this, LoginActivity::class.java)) }
  }

  override fun startMainScreen() = startActivity(MainActivity.getLaunchIntent(this))
}
