package com.syntax.android.learn.presentation.implementation

import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.firebase.database.FirebaseDatabaseInterface
import com.syntax.android.learn.model.Joke
import com.syntax.android.learn.presentation.AllJokesPresenter
import com.syntax.android.learn.ui.jokes.all.AllJokesView
import javax.inject.Inject

class AllJokesPresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : AllJokesPresenter {

  private lateinit var view: AllJokesView

  override fun setView(view: AllJokesView) {
    this.view = view
  }

  override fun viewReady() {
    getAllJokes()
  }

  override fun getAllJokes() = databaseInterface.listenToJokes { view.addJoke(it) }

  override fun onFavoriteButtonTapped(joke: Joke) {
    databaseInterface.changeJokeFavoriteStatus(joke, authenticationInterface.getUserId())
  }
}

