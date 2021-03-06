package com.syntax.android.learn.ui.profile

interface ProfileView {

  fun showUsername(username: String)

  fun showEmail(email: String)

  fun showNumberOfJokes(jokesCount: Int)

  fun openWelcome()
}