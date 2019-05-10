package com.syntax.android.learn.presentation.implementation

import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.firebase.database.FirebaseDatabaseInterface
import com.syntax.android.learn.presentation.ProfilePresenter
import com.syntax.android.learn.ui.profile.ProfileView
import javax.inject.Inject

class ProfilePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : ProfilePresenter {

  private lateinit var view: ProfileView

  override fun setView(view: ProfileView) {
    this.view = view
  }

  override fun getProfile() {
    databaseInterface.getProfile(authenticationInterface.getUserId()) {
      val userId = authenticationInterface.getUserId()

      view.showUsername(it.username)
      view.showEmail(it.email)
      view.showNumberOfJokes(it.favoriteJokes.count { it.authorId==userId })
    }
  }

  override fun logOut() = authenticationInterface.logOut { view.openWelcome() }
}