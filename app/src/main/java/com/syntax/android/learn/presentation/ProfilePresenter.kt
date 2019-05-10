package com.syntax.android.learn.presentation

import com.syntax.android.learn.ui.profile.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {

  fun getProfile()

  fun logOut()
}